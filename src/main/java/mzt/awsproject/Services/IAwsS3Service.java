package mzt.awsproject.Services;

import org.springframework.web.multipart.MultipartFile;

public interface IAwsS3Service {
    void uploadFile(long id, MultipartFile file);
    String getLinkFromS3 (long id, String fileName);
}
