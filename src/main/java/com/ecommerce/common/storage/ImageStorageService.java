package com.ecommerce.common.storage;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {

  String uploadImage(MultipartFile file) throws IOException;

  void deleteImage(String imageUrl) throws IOException;
}
