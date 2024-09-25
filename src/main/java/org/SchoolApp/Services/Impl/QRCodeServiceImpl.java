package org.SchoolApp.Services.Impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.SchoolApp.Services.Interfaces.QRCodeService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class QRCodeServiceImpl implements QRCodeService {

    @Override
    public String generateQRCode(String matricule) {
        try {
            String directoryPath = "qr_codes/";
            String filePath = directoryPath + matricule + ".png";

            // Ensure the directory exists
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();  // Create the directory if it doesn't exist
            }

            // Generate QR code
            BitMatrix matrix = new MultiFormatWriter().encode(matricule, BarcodeFormat.QR_CODE, 200, 200);
            Path path = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);

            return filePath;  // Return the file path to the generated QR code
        } catch (Exception e) {
            throw new RuntimeException("Error generating QR code", e);
        }
    }
}
