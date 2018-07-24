/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Norberto
 */
public class JFDemoProyecto extends javax.swing.JFrame {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_demodos", "root", "");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    private void Consulta() {
        this.Conectar();
        try {
            ps = conexion.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();

            rs.next();
            this.jTextFieldIDProducto.setText(rs.getString("id_producto"));
            this.jTextFieldNombreProducto.setText(rs.getString("nombre_producto"));
            this.jTextFieldPrecioProducto.setText(rs.getString("precio_compra"));
            this.jTextFieldExistenciasProducto.setText(rs.getString("existencias_producto"));
            this.jComboBoxMarca.setSelectedItem(rs.getString("marca_producto"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }

    private void limpiarCajas() {
        this.Conectar();
        jTextFieldIDProducto.setText(null);
        jTextFieldNombreProducto.setText(null);
        jTextFieldPrecioProducto.setText(null);
        jTextFieldExistenciasProducto.setText(null);
        jComboBoxMarca.setSelectedIndex(0);
    }

    private void siguienteRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.next();
                this.jTextFieldIDProducto.setText(rs.getString("id_producto"));
                this.jTextFieldNombreProducto.setText(rs.getString("nombre_producto"));
                this.jTextFieldPrecioProducto.setText(rs.getString("precio_compra"));
                this.jTextFieldExistenciasProducto.setText(rs.getString("existencias_producto"));
                this.jComboBoxMarca.setSelectedItem(rs.getString("marca_producto"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    private void anteriorRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.previous();
                this.jTextFieldIDProducto.setText(rs.getString("id_producto"));
                this.jTextFieldNombreProducto.setText(rs.getString("nombre_producto"));
                this.jTextFieldPrecioProducto.setText(rs.getString("precio_compra"));
                this.jTextFieldExistenciasProducto.setText(rs.getString("existencias_producto"));
                this.jComboBoxMarca.setSelectedItem(rs.getString("marca_producto"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    private void primerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first();
                this.jTextFieldIDProducto.setText(rs.getString("id_producto"));
                this.jTextFieldNombreProducto.setText(rs.getString("nombre_producto"));
                this.jTextFieldPrecioProducto.setText(rs.getString("precio_compra"));
                this.jTextFieldExistenciasProducto.setText(rs.getString("existencias_producto"));
                this.jComboBoxMarca.setSelectedItem(rs.getString("marca_producto"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    private void ultimoRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.last();
                this.jTextFieldIDProducto.setText(rs.getString("id_producto"));
                this.jTextFieldNombreProducto.setText(rs.getString("nombre_producto"));
                this.jTextFieldPrecioProducto.setText(rs.getString("precio_compra"));
                this.jTextFieldExistenciasProducto.setText(rs.getString("existencias_producto"));
                this.jComboBoxMarca.setSelectedItem(rs.getString("marca_producto"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Creates new form JFDemoProyecto
     */
    public JFDemoProyecto() {
        initComponents();
        Conectar();
        Consulta();
        this.setLocationRelativeTo(null);
        for (Component component : jPanelAcciones.getComponents()) {
            component.setEnabled(false);
        }
        jTextFieldIDProducto.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelActivar = new javax.swing.JPanel();
        jButtonBotones = new javax.swing.JButton();
        jButtonEdicion = new javax.swing.JButton();
        jPanelBotones = new javax.swing.JPanel();
        jButtonPrimero = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonUltimo = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jPanelAcciones = new javax.swing.JPanel();
        jButtonActualizarProducto = new javax.swing.JButton();
        jButtonNuevoProducto = new javax.swing.JButton();
        jButtonBorrarProducto = new javax.swing.JButton();
        jButtonGuardarProducto = new javax.swing.JButton();
        jButtonCancelarProducto = new javax.swing.JButton();
        jPanelProducto = new javax.swing.JPanel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldIDProducto = new javax.swing.JTextField();
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jLabelNombreProducto = new javax.swing.JLabel();
        jTextFieldPrecioProducto = new javax.swing.JTextField();
        jLabelPrecioProducto = new javax.swing.JLabel();
        jTextFieldExistenciasProducto = new javax.swing.JTextField();
        jLabelExistenciasProducto = new javax.swing.JLabel();
        jComboBoxTipoBusq = new javax.swing.JComboBox<>();
        jLabelExistenciasProducto1 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 800));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jPanelActivar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonBotones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonBotones.setText("Botones");
        jButtonBotones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBotonesActionPerformed(evt);
            }
        });

        jButtonEdicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonEdicion.setText("Edición");
        jButtonEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelActivarLayout = new javax.swing.GroupLayout(jPanelActivar);
        jPanelActivar.setLayout(jPanelActivarLayout);
        jPanelActivarLayout.setHorizontalGroup(
            jPanelActivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActivarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBotones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButtonEdicion)
                .addContainerGap())
        );
        jPanelActivarLayout.setVerticalGroup(
            jPanelActivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActivarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelActivarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonPrimero.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButtonPrimero.setText("|<");
        jButtonPrimero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPrimeroMouseClicked(evt);
            }
        });
        jButtonPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeroActionPerformed(evt);
            }
        });

        jButtonAnterior.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButtonAnterior.setText("<<");
        jButtonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAnteriorMouseClicked(evt);
            }
        });
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonUltimo.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButtonUltimo.setText(">|");
        jButtonUltimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUltimoMouseClicked(evt);
            }
        });
        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoActionPerformed(evt);
            }
        });

        jButtonSiguiente.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jButtonSiguiente.setText(">>");
        jButtonSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSiguienteMouseClicked(evt);
            }
        });
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPrimero)
                .addGap(45, 45, 45)
                .addComponent(jButtonAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jButtonSiguiente)
                .addGap(41, 41, 41)
                .addComponent(jButtonUltimo)
                .addContainerGap())
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrimero)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonUltimo)
                    .addComponent(jButtonSiguiente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Edición"));

        jButtonActualizarProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonActualizarProducto.setText("Actualizar");
        jButtonActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarProductoActionPerformed(evt);
            }
        });

        jButtonNuevoProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonNuevoProducto.setText("Nuevo");
        jButtonNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNuevoProductoMouseClicked(evt);
            }
        });
        jButtonNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoProductoActionPerformed(evt);
            }
        });

        jButtonBorrarProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonBorrarProducto.setText("Borrar");
        jButtonBorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarProductoActionPerformed(evt);
            }
        });

        jButtonGuardarProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonGuardarProducto.setText("Guardar");
        jButtonGuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarProductoMouseClicked(evt);
            }
        });
        jButtonGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarProductoActionPerformed(evt);
            }
        });

        jButtonCancelarProducto.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jButtonCancelarProducto.setText("Cancelar");
        jButtonCancelarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAccionesLayout = new javax.swing.GroupLayout(jPanelAcciones);
        jPanelAcciones.setLayout(jPanelAccionesLayout);
        jPanelAccionesLayout.setHorizontalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccionesLayout.createSequentialGroup()
                        .addGroup(jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCancelarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBorrarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonActualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanelAccionesLayout.createSequentialGroup()
                        .addGroup(jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonGuardarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanelAccionesLayout.setVerticalGroup(
            jPanelAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNuevoProducto)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardarProducto)
                .addGap(18, 18, 18)
                .addComponent(jButtonActualizarProducto)
                .addGap(18, 18, 18)
                .addComponent(jButtonBorrarProducto)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelarProducto)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanelProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Producto"));

        jLabelID.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelID.setText("ID:");

        jTextFieldIDProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldIDProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDProductoActionPerformed(evt);
            }
        });

        jTextFieldNombreProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabelNombreProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNombreProducto.setText("Nombre:");

        jTextFieldPrecioProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecioProductoKeyTyped(evt);
            }
        });

        jLabelPrecioProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelPrecioProducto.setText("Precio:");

        jTextFieldExistenciasProducto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldExistenciasProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldExistenciasProductoKeyTyped(evt);
            }
        });

        jLabelExistenciasProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelExistenciasProducto.setText("Existencias:");

        jComboBoxTipoBusq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Precio", "Existencias" }));

        jLabelExistenciasProducto1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelExistenciasProducto1.setText("Marca:");

        jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Apple", "Samsung", "LG", "Motorola", "Generico" }));

        javax.swing.GroupLayout jPanelProductoLayout = new javax.swing.GroupLayout(jPanelProducto);
        jPanelProducto.setLayout(jPanelProductoLayout);
        jPanelProductoLayout.setHorizontalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelID)
                    .addComponent(jLabelExistenciasProducto1)
                    .addComponent(jLabelExistenciasProducto)
                    .addComponent(jLabelPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreProducto))
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxMarca, 0, 200, Short.MAX_VALUE)
                            .addComponent(jTextFieldExistenciasProducto))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxTipoBusq, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProductoLayout.setVerticalGroup(
            jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductoLayout.createSequentialGroup()
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addComponent(jTextFieldIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelExistenciasProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipoBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelProductoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldExistenciasProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelExistenciasProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelActivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelActivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrimeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPrimeroMouseClicked

    }//GEN-LAST:event_jButtonPrimeroMouseClicked

    private void jButtonPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeroActionPerformed
        Consulta();
        this.primerRegistro();
    }//GEN-LAST:event_jButtonPrimeroActionPerformed

    private void jButtonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAnteriorMouseClicked

    }//GEN-LAST:event_jButtonAnteriorMouseClicked

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        this.anteriorRegistro();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSiguienteMouseClicked

    }//GEN-LAST:event_jButtonSiguienteMouseClicked

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        this.siguienteRegistro();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonUltimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUltimoMouseClicked

    }//GEN-LAST:event_jButtonUltimoMouseClicked

    private void jButtonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoActionPerformed
        Consulta();
        this.ultimoRegistro();
    }//GEN-LAST:event_jButtonUltimoActionPerformed

    private void jButtonGuardarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarProductoMouseClicked

    }//GEN-LAST:event_jButtonGuardarProductoMouseClicked

    private void jButtonGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarProductoActionPerformed
        try {
            int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea guardar este producto?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancelar == 0) {
                try {
                    ps = conexion.prepareStatement("INSERT INTO productos (nombre_producto, precio_compra, existencias_producto, marca_producto) VALUES(?,?,?,?)");
                    ps.setString(1, jTextFieldNombreProducto.getText());
                    ps.setString(2, jTextFieldPrecioProducto.getText());
                    ps.setString(3, jTextFieldExistenciasProducto.getText());
                    ps.setString(4, jComboBoxMarca.getSelectedItem().toString());

                    int rs = ps.executeUpdate();
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "Producto Guardado");
                        limpiarCajas();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar el Producto");
                        limpiarCajas();
                    }
                    conexion.close();
                    Consulta();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se guardo ningun producto");
            }

        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonGuardarProductoActionPerformed

    private void jTextFieldIDProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDProductoActionPerformed

    }//GEN-LAST:event_jTextFieldIDProductoActionPerformed

    private void jTextFieldPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecioProductoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPrecioProductoKeyTyped

    private void jTextFieldExistenciasProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldExistenciasProductoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldExistenciasProductoKeyTyped

    private void jButtonNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoProductoActionPerformed

        jButtonGuardarProducto.setEnabled(true);
        jButtonCancelarProducto.setEnabled(true);
        jButtonActualizarProducto.setEnabled(false);
        jButtonBorrarProducto.setEnabled(false);
        jButtonNuevoProducto.setEnabled(false);

    }//GEN-LAST:event_jButtonNuevoProductoActionPerformed

    private void jButtonActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarProductoActionPerformed
        try {
            int cancelar = JOptionPane.showConfirmDialog(null, "¿Desea Actualizar este producto?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancelar == 0) {
                try {
                    ps = conexion.prepareStatement("UPDATE productos set nombre_producto=?, precio_compra=?, existencias_producto=?, marca_producto=? WHERE id_producto=?");
                    ps.setString(1, jTextFieldNombreProducto.getText());
                    ps.setString(2, jTextFieldPrecioProducto.getText());
                    ps.setString(3, jTextFieldExistenciasProducto.getText());
                    ps.setString(4, jComboBoxMarca.getSelectedItem().toString());
                    ps.setString(5, jTextFieldIDProducto.getText());

                    int rs = ps.executeUpdate();
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "Producto Modificado");
                        limpiarCajas();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar el Producto");
                        limpiarCajas();
                    }
                    conexion.close();
                    Consulta();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se actualizo ningun producto");
            }

        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonActualizarProductoActionPerformed

    private void jButtonCancelarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarProductoActionPerformed
        this.limpiarCajas();
        jButtonGuardarProducto.setEnabled(false);
        jButtonNuevoProducto.setEnabled(true);
        jButtonActualizarProducto.setEnabled(true);
        jButtonBorrarProducto.setEnabled(true);
    }//GEN-LAST:event_jButtonCancelarProductoActionPerformed

    private void jButtonBorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarProductoActionPerformed
        try {
            int cancelar = JOptionPane.showConfirmDialog(null, "¿Realmente desea Borrar este producto?", "Confirmar salida", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (cancelar == 0) {
                try {
                    ps = conexion.prepareStatement("DELETE FROM productos WHERE id_producto=?");
                    ps.setInt(1, Integer.parseInt(jTextFieldIDProducto.getText()));

                    int rs = ps.executeUpdate();
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "Producto Eliminado");
                        limpiarCajas();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar el Producto");
                        limpiarCajas();
                    }
                    conexion.close();
                    Consulta();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se borro ningun producto");
            }

        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonBorrarProductoActionPerformed

    private void jButtonNuevoProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNuevoProductoMouseClicked

    }//GEN-LAST:event_jButtonNuevoProductoMouseClicked

    private void jButtonBotonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBotonesActionPerformed
        for (Component component : jPanelBotones.getComponents()) {
            component.setEnabled(true);
        }
        for (Component component : jPanelAcciones.getComponents()) {
            component.setEnabled(false);
        }
        jTextFieldIDProducto.setEnabled(false);

    }//GEN-LAST:event_jButtonBotonesActionPerformed

    private void jButtonEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdicionActionPerformed
        for (Component component : jPanelBotones.getComponents()) {
            component.setEnabled(false);
        }
        for (Component component : jPanelAcciones.getComponents()) {
            component.setEnabled(true);
        }
        jTextFieldIDProducto.setEnabled(false);
        jButtonGuardarProducto.setEnabled(false);
    }//GEN-LAST:event_jButtonEdicionActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        Imagen Imagen = new Imagen();
        this.add(Imagen);
        this.repaint();
    }//GEN-LAST:event_formPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDemoProyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarProducto;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBorrarProducto;
    private javax.swing.JButton jButtonBotones;
    private javax.swing.JButton jButtonCancelarProducto;
    private javax.swing.JButton jButtonEdicion;
    private javax.swing.JButton jButtonGuardarProducto;
    private javax.swing.JButton jButtonNuevoProducto;
    private javax.swing.JButton jButtonPrimero;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JButton jButtonUltimo;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxTipoBusq;
    private javax.swing.JLabel jLabelExistenciasProducto;
    private javax.swing.JLabel jLabelExistenciasProducto1;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelPrecioProducto;
    private javax.swing.JPanel jPanelAcciones;
    private javax.swing.JPanel jPanelActivar;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelProducto;
    private javax.swing.JTextField jTextFieldExistenciasProducto;
    private javax.swing.JTextField jTextFieldIDProducto;
    private javax.swing.JTextField jTextFieldNombreProducto;
    private javax.swing.JTextField jTextFieldPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
