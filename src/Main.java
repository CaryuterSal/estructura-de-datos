import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Corazón - Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new HeartPanel());
            frame.setSize(500, 520);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class HeartPanel extends JPanel {
    public HeartPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Preparar Graphics2D
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Coordenadas base del corazón (caja de 200x200)
        GeneralPath heart = new GeneralPath();
        // Empieza en la parte superior-central izquierda del corazón
        heart.moveTo(100, 40);
        // mitad izquierda (curvas hacia abajo al pico)
        heart.curveTo(100, 15, 60, 15, 50, 40);
        heart.curveTo(20, 70, 50, 110, 100, 150);
        // mitad derecha (simétrica)
        heart.curveTo(150, 110, 180, 70, 150, 40);
        heart.curveTo(140, 15, 100, 15, 100, 40);
        heart.closePath();

        // Escalado y centrado dinámico
        int w = getWidth();
        int h = getHeight();

        double scale = Math.min(w / 220.0, h / 220.0); // caja base + margenes
        AffineTransform at = new AffineTransform();
        // mover el origen para centrar el corazón
        double tx = (w - 200 * scale) / 2.0;
        double ty = (h - 200 * scale) / 2.0;
        at.translate(tx, ty);
        at.scale(scale, scale);

        Shape heartScaled = at.createTransformedShape(heart);

        Rectangle bounds = heartScaled.getBounds();
        GradientPaint gp = new GradientPaint(
                (float) bounds.getCenterX(), bounds.y,
                new Color(255, 80, 100),
                (float) bounds.getCenterX(), bounds.y + bounds.height,
                new Color(180, 10, 40)
        );

        AffineTransform shadowAt = AffineTransform.getTranslateInstance(4, 6);
        Shape shadow = shadowAt.createTransformedShape(heartScaled);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f));
        g2.setColor(Color.BLACK);
        g2.fill(shadow);

        // Dibujar corazón con borde y relleno degradado
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setPaint(gp);
        g2.fill(heartScaled);

        g2.setStroke(new BasicStroke((float)(2.0 / scale))); // borde consistente al escalar
        g2.setColor(new Color(120, 10, 30));
        g2.draw(heartScaled);
        g2.setFont(new Font("SansSerif", Font.BOLD, (int)(18 / scale)));
        g2.setColor(new Color(80, 80, 80));
        FontMetrics fm = g2.getFontMetrics();

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 420);
    }
}
