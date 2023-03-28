import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {

    public void create(InputStream inputStream, String fileName) throws Exception {
        BufferedImage originalImage = ImageIO.read(inputStream);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 50;
        
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var fonte = new Font(Font.MONOSPACED, Font.BOLD, 22);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        graphics.drawString("TOPZERA", 20, newHeight - 20);

        ImageIO.write(newImage, "png", new File(fileName));

    }

}
