package com.ecommerce.common.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageStorageService {

    String uploadImage(MultipartFile file) throws IOException;

    void deleteImage(String imageUrl) throws IOException;
}
