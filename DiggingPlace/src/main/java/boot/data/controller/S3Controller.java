package boot.data.controller;

import java.io.IOException;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class S3Controller {

	private final AmazonS3Client amazonS3Client;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	@Value("${cloud.aws.s3.upload-profile}")
	private String uploadprofile;

	@Autowired
	MemberService mservice;

	@PostMapping("/member/updateprofile")
	public String updateprofile(MultipartFile image, HttpSession session, MemberDto dto) throws IOException {

		String loginemail = (String) session.getAttribute("loginemail");
		String nickname = mservice.getMemberName(loginemail);
		System.out.println(nickname);
		String name = nickname + "_" + image.getOriginalFilename();
		String bucketkey = uploadprofile + name;
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType(image.getContentType());
		objectMetadata.setContentLength(image.getSize());
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, bucketkey, image.getInputStream(),
				objectMetadata);
		amazonS3Client.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead));
		log.debug("s3 파일 업로드 완료");
		String uploadurl = amazonS3Client.getUrl(bucket, bucketkey).toString();
		System.out.println(uploadurl);
		if (image.isEmpty()) {
			dto.setMember_photo(null);
		} else {
			dto.setMember_photo(uploadurl);
			mservice.MemberProfileUpdate(dto);
		}
		return "redirect:/myinfo";
	}

}
