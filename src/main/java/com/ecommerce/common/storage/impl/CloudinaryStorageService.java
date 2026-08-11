package com.ecommerce.common.storage.impl;

import com.cloudinary.Cloudinary;
import com.ecommerce.common.storage.ImageStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryStorageService implements ImageStorageService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        Map uploadResult =
                cloudinary.uploader().upload(
                        file.getBytes(),
                        Map.of()
                );

        return uploadResult
                .get("secure_url")
                .toString();
    }

    @Override
    public void deleteImage(String imageUrl) throws IOException {
        String publicId = extractPublicId(imageUrl);
        cloudinary.uploader().destroy(publicId, Map.of());
    }

    private String extractPublicId(String imageUrl) {
        String[] parts = imageUrl.split("/upload/");

        if (parts.length < 2) {

            throw new IllegalArgumentException("Invalid Cloudinary image URL");
        }

        String path = parts[1];

        path = path.replaceFirst("^v\\d+/", "");

        int extensionIndex = path.lastIndexOf(".");

        if (extensionIndex != -1) {

            path = path.substring(0, extensionIndex);
        }

        return path;
    }
}
