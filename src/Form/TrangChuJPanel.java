/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form;

import DAO.NhanVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author 123tu
 */
public class TrangChuJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrangChuJPanel1
     */
    NhanVienDAO daoNV = new NhanVienDAO();

    public TrangChuJPanel() {
        initComponents();

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                String text = sdf.format(now);
                lblDongHo.setText(text);
            }
        }).start();
        
        if (!isManager()) {
            jpnNhanVien.setVisible(false);
            lblNhanVien.setVisible(false);
            jpnThongKe.setVisible(false);
            lblThongKe.setVisible(false);
        }
    }

    boolean isManager() {
        return daoNV.isManager(MainJFrame.NhanVienID);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpnPhongChieu = new javax.swing.JPanel();
        lblPhongChieu = new javax.swing.JLabel();
        jpnPhim = new javax.swing.JPanel();
        lblPhim = new javax.swing.JLabel();
        jpnSuatChieu = new javax.swing.JPanel();
        lblSuatChieu = new javax.swing.JLabel();
        jpnVe = new javax.swing.JPanel();
        lblVe = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpnTrong1 = new javax.swing.JPanel();
        jpnNhanVien = new javax.swing.JPanel();
        lblNhanVien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jpnThongKe = new javax.swing.JPanel();
        lblThongKe = new javax.swing.JLabel();

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 51, 51));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CINEMAX");

        lblDongHo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDongHo.setForeground(new java.awt.Color(255, 255, 255));
        lblDongHo.setText("00:00:00 AM");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Trang Chủ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel9)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDongHo)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(0, 0, 1305, 96);

        jpnPhongChieu.setBackground(new java.awt.Color(255, 51, 51));
        jpnPhongChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnPhongChieuMouseClicked(evt);
            }
        });

        lblPhongChieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhongChieu.setForeground(new java.awt.Color(255, 255, 255));
        lblPhongChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PhongChieu.png"))); // NOI18N
        lblPhongChieu.setText("Phòng Chiếu");
        lblPhongChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhongChieuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnPhongChieuLayout = new javax.swing.GroupLayout(jpnPhongChieu);
        jpnPhongChieu.setLayout(jpnPhongChieuLayout);
        jpnPhongChieuLayout.setHorizontalGroup(
            jpnPhongChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhongChieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhongChieu)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jpnPhongChieuLayout.setVerticalGroup(
            jpnPhongChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPhongChieuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPhongChieu)
                .addContainerGap())
        );

        add(jpnPhongChieu);
        jpnPhongChieu.setBounds(222, 102, 202, 76);

        jpnPhim.setBackground(new java.awt.Color(255, 51, 51));
        jpnPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnPhimMouseClicked(evt);
            }
        });

        lblPhim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhim.setForeground(new java.awt.Color(255, 255, 255));
        lblPhim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Phim.png"))); // NOI18N
        lblPhim.setText("Phim");
        lblPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhimMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnPhimLayout = new javax.swing.GroupLayout(jpnPhim);
        jpnPhim.setLayout(jpnPhimLayout);
        jpnPhimLayout.setHorizontalGroup(
            jpnPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnPhimLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(lblPhim)
                .addGap(43, 43, 43))
        );
        jpnPhimLayout.setVerticalGroup(
            jpnPhimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhimLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPhim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jpnPhim);
        jpnPhim.setBounds(436, 102, 201, 76);

        jpnSuatChieu.setBackground(new java.awt.Color(255, 51, 51));
        jpnSuatChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnSuatChieuMouseClicked(evt);
            }
        });

        lblSuatChieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSuatChieu.setForeground(new java.awt.Color(255, 255, 255));
        lblSuatChieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/SuatChieu.png"))); // NOI18N
        lblSuatChieu.setText("Suất Chiếu");
        lblSuatChieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSuatChieuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnSuatChieuLayout = new javax.swing.GroupLayout(jpnSuatChieu);
        jpnSuatChieu.setLayout(jpnSuatChieuLayout);
        jpnSuatChieuLayout.setHorizontalGroup(
            jpnSuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSuatChieuLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(lblSuatChieu)
                .addGap(19, 19, 19))
        );
        jpnSuatChieuLayout.setVerticalGroup(
            jpnSuatChieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSuatChieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSuatChieu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jpnSuatChieu);
        jpnSuatChieu.setBounds(649, 102, 201, 76);

        jpnVe.setBackground(new java.awt.Color(255, 51, 51));
        jpnVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnVeMouseClicked(evt);
            }
        });

        lblVe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVe.setForeground(new java.awt.Color(255, 255, 255));
        lblVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/VE.png"))); // NOI18N
        lblVe.setText("Vé");
        lblVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnVeLayout = new javax.swing.GroupLayout(jpnVe);
        jpnVe.setLayout(jpnVeLayout);
        jpnVeLayout.setHorizontalGroup(
            jpnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnVeLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblVe)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jpnVeLayout.setVerticalGroup(
            jpnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnVeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jpnVe);
        jpnVe.setBounds(862, 102, 200, 76);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(351, 231, 525, 446);

        jpnNhanVien.setBackground(new java.awt.Color(255, 51, 51));
        jpnNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnNhanVienMouseClicked(evt);
            }
        });

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NhanVien.png"))); // NOI18N
        lblNhanVien.setText("Nhân Viên");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNhanVien)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnTrong1Layout = new javax.swing.GroupLayout(jpnTrong1);
        jpnTrong1.setLayout(jpnTrong1Layout);
        jpnTrong1Layout.setHorizontalGroup(
            jpnTrong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTrong1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnTrong1Layout.setVerticalGroup(
            jpnTrong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrong1Layout.createSequentialGroup()
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        add(jpnTrong1);
        jpnTrong1.setBounds(8, 102, 201, 85);

        jpnThongKe.setBackground(new java.awt.Color(255, 51, 51));
        jpnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnThongKeMouseClicked(evt);
            }
        });

        lblThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lblThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ThongKe.png"))); // NOI18N
        lblThongKe.setText("Thống Kê");
        lblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongKeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblThongKe)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(jPanel3);
        jPanel3.setBounds(1074, 102, 201, 90);
    }// </editor-fold>//GEN-END:initComponents

    private void jpnNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnNhanVienMouseClicked
        MainJFrame.showForm(new NhanVienJPanel());
    }//GEN-LAST:event_jpnNhanVienMouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        MainJFrame.showForm(new NhanVienJPanel());
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblPhongChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhongChieuMouseClicked
        MainJFrame.showForm(new PhongChieuJPanel());
    }//GEN-LAST:event_lblPhongChieuMouseClicked

    private void jpnPhongChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnPhongChieuMouseClicked
        MainJFrame.showForm(new PhongChieuJPanel());
    }//GEN-LAST:event_jpnPhongChieuMouseClicked

    private void jpnPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnPhimMouseClicked
        MainJFrame.showForm(new PhimJPanel());
    }//GEN-LAST:event_jpnPhimMouseClicked

    private void lblPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhimMouseClicked
        MainJFrame.showForm(new PhimJPanel());
    }//GEN-LAST:event_lblPhimMouseClicked

    private void jpnSuatChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnSuatChieuMouseClicked
        MainJFrame.showForm(new SuatChieuJPanel(null));
    }//GEN-LAST:event_jpnSuatChieuMouseClicked

    private void lblSuatChieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuatChieuMouseClicked
        MainJFrame.showForm(new SuatChieuJPanel(null));
    }//GEN-LAST:event_lblSuatChieuMouseClicked

    private void jpnVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnVeMouseClicked
        MainJFrame.showForm(new VeJPanel());
    }//GEN-LAST:event_jpnVeMouseClicked

    private void lblVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVeMouseClicked
        MainJFrame.showForm(new VeJPanel());
    }//GEN-LAST:event_lblVeMouseClicked

    private void lblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongKeMouseClicked
        MainJFrame.showForm(new ThongKeJPanel());
    }//GEN-LAST:event_lblThongKeMouseClicked

    private void jpnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnThongKeMouseClicked
        MainJFrame.showForm(new ThongKeJPanel());
    }//GEN-LAST:event_jpnThongKeMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnPhim;
    private javax.swing.JPanel jpnPhongChieu;
    private javax.swing.JPanel jpnSuatChieu;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnTrong1;
    private javax.swing.JPanel jpnVe;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblPhim;
    private javax.swing.JLabel lblPhongChieu;
    private javax.swing.JLabel lblSuatChieu;
    private javax.swing.JLabel lblThongKe;
    private javax.swing.JLabel lblVe;
    // End of variables declaration//GEN-END:variables
}
