package View;

import Controller.conectaBanco;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public final class telaPrincipalMaster implements ActionListener {

    conectaBanco bd = new conectaBanco();

    ResultSet Dado, Dado1;
    int cont = 0;

    private JFrame frame;
    private JPanel panel, panelMenu, panelMenuSombra, panelBuscar, sombraBuscar, sombraBarra, sombraBCadastrar, sombraBAlterar, sombraBExcluir, sombraBSair, sombraBAtualizar;
    private JSeparator separadorMenu, separadorMenu2, separadorFuncionarios, separadorAtualizar;
    private JLabel funcionarios, buscar, menu;
    private JTextField textBuscar;
    private JTable tabelaListar;
    private JScrollPane barra;
    private JButton bCadastrar, bAlterar, bExcluir, bSair, bAtualizar;
    private final DefaultTableModel modelo = (DefaultTableModel) (new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int coluna) {
            return false;
        }

        public boolean isCellRedimentionable(int row, int coluna) {
            return true;
        }

    });

    public telaPrincipalMaster() {

        gui();

    }

    public void gui() {

        // LABEL FUNCIONARIOS //
        funcionarios = new JLabel("Funcionários");
        funcionarios.setBounds(10, 10, 130, 20);
        funcionarios.setFont(new Font("Urbandub", Font.PLAIN, 20));
        funcionarios.setForeground(Color.BLACK);

        separadorFuncionarios = new JSeparator();
        separadorFuncionarios.setBounds(10, 40, 930, 1);
        separadorFuncionarios.setBorder(new LineBorder(Color.BLACK));

        // BUSCAR //
        buscar = new JLabel("Buscar:");
        buscar.setBounds(20, 60, 65, 30);
        buscar.setFont(new Font("Urbandub", Font.BOLD, 12));

        textBuscar = new JTextField();
        textBuscar.setBounds(80, 66, 715, 20);
        textBuscar.setBorder(new LineBorder(Color.WHITE));
        textBuscar.setFont(new Font("Urbandub", Font.BOLD, 12));
        textBuscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                panelBuscar.setBounds(10, 60, 790, 30);
                sombraBuscar.setBounds(10, 60, 790, 32);
                buscar.setFont(new Font("Urbandub", Font.BOLD, 12));
                textBuscar.setFont(new Font("Urbandub", Font.PLAIN, 12));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                panelBuscar.setBounds(7, 57, 795, 36);
                sombraBuscar.setBounds(11, 60, 787, 36);
                buscar.setFont(new Font("Urbandub", Font.BOLD, 14));
                textBuscar.setFont(new Font("Urbandub", Font.PLAIN, 14));

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }

        });

        panelBuscar = new JPanel();
        panelBuscar.setBounds(10, 60, 790, 30);
        panelBuscar.setBackground(Color.WHITE);
        panelBuscar.setBorder(new LineBorder(Color.BLACK));
        panelBuscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                panelBuscar.setBounds(10, 60, 790, 30);
                sombraBuscar.setBounds(10, 60, 790, 32);
                buscar.setFont(new Font("Urbandub", Font.BOLD, 12));
                textBuscar.setFont(new Font("Urbandub", Font.PLAIN, 12));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                panelBuscar.setBounds(7, 57, 795, 36);
                sombraBuscar.setBounds(11, 60, 787, 36);
                buscar.setFont(new Font("Urbandub", Font.BOLD, 14));
                textBuscar.setFont(new Font("Urbandub", Font.PLAIN, 14));

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }

        });

        sombraBuscar = new JPanel();
        sombraBuscar.setBounds(10, 60, 790, 32);
        sombraBuscar.setBackground(Color.GRAY);

        separadorAtualizar = new JSeparator();
        separadorAtualizar.setBounds(810, 60, 1, 32);
        separadorAtualizar.setBorder(new LineBorder(Color.BLACK));

        bAtualizar = new JButton("Atualizar");
        bAtualizar.setBounds(820, 60, 120, 30);
        bAtualizar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        bAtualizar.setFocusPainted(false);
        bAtualizar.setBackground(Color.decode("#9999ff"));
        bAtualizar.setForeground(Color.WHITE);
        bAtualizar.setBorder(new LineBorder(Color.BLACK));
        bAtualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                bAtualizar.setBounds(820, 60, 120, 30);
                sombraBAtualizar.setBounds(820, 60, 120, 32);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                bAtualizar.setBounds(817, 57, 125, 36);
                sombraBAtualizar.setBounds(821, 60, 117, 36);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }

        });

        sombraBAtualizar = new JPanel();
        sombraBAtualizar.setBackground(Color.GRAY);
        sombraBAtualizar.setBounds(820, 60, 120, 32);

        // TABELA //
        bd.connection();

        // Preenchimento da tabela com os dados do banco //
        String sql = "select * from  funcionario";

        Statement stmt;

        try {

            stmt = bd.con.prepareStatement(sql);

            Dado = stmt.executeQuery(sql);

            while (Dado.next()) {

                cont += 1;

            }
        } catch (SQLException n) {

            JOptionPane.showMessageDialog(null, n);

        }

        // Setando as colunas e as celulas da tabela //
        String[] colunas = {"Código", "Nome", "CPF", "RG", "Cargo", "Telefone", "Email"};

        modelo.setColumnIdentifiers(colunas);
        modelo.setNumRows(0);

        String sql1 = "select * from funcionario";

        Statement stmt1;

        try {
            stmt1 = bd.con.prepareStatement(sql1);

            Dado1 = stmt1.executeQuery(sql1);

            while (Dado1.next()) {

                String[] dados = new String[7];

                for (int i = 0; i < 7; i++) {
                    dados[0] = Dado1.getString("id");
                    dados[1] = Dado1.getString("Nome");
                    dados[2] = Dado1.getString("Cpf");
                    dados[3] = Dado1.getString("Rg");
                    dados[4] = Dado1.getString("Cargo");
                    dados[5] = Dado1.getString("NumCell");
                    dados[6] = Dado1.getString("Email");

                }
                modelo.addRow(dados);

            }

        } catch (SQLException n) {

            JOptionPane.showMessageDialog(null, n);

        }

        tabelaListar = new JTable();
        tabelaListar.setBackground(Color.WHITE);
        tabelaListar.setModel(modelo);
        tabelaListar.setFillsViewportHeight(true);

        barra = new JScrollPane(tabelaListar);
        barra.setBounds(10, 100, 930, 454);
        barra.setBorder(new LineBorder(Color.BLACK));

        sombraBarra = new JPanel();
        sombraBarra.setBounds(10, 100, 930, 456);
        sombraBarra.setBackground(Color.GRAY);

        // MENU //
        bCadastrar = new JButton("Cadastrar");
        bCadastrar.setBounds(60, 40, 233, 50);
        bCadastrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bCadastrar.setFocusPainted(false);
        bCadastrar.setBackground(Color.WHITE);
        bCadastrar.setBorder(new LineBorder(Color.BLACK));
        bCadastrar.addActionListener(this);
        bCadastrar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                bCadastrar.setBounds(60, 40, 233, 50);
                sombraBCadastrar.setBounds(60, 40, 233, 52);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                bCadastrar.setBounds(57, 37, 238, 56);
                sombraBCadastrar.setBounds(61, 40, 230, 56);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        sombraBCadastrar = new JPanel();
        sombraBCadastrar.setBackground(Color.GRAY);
        sombraBCadastrar.setBounds(60, 40, 233, 52);

        bAlterar = new JButton("Alterar");
        bAlterar.setBounds(60, 110, 233, 50);
        bAlterar.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bAlterar.setFocusPainted(false);
        bAlterar.setBackground(Color.WHITE);
        bAlterar.setBorder(new LineBorder(Color.BLACK));
        bAlterar.addActionListener(this);
        bAlterar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                bAlterar.setBounds(60, 110, 233, 50);
                sombraBAlterar.setBounds(60, 110, 233, 52);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                bAlterar.setBounds(57, 107, 238, 56);
                sombraBAlterar.setBounds(61, 110, 230, 56);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        sombraBAlterar = new JPanel();
        sombraBAlterar.setBackground(Color.GRAY);
        sombraBAlterar.setBounds(60, 110, 233, 52);

        bExcluir = new JButton("Excluir");
        bExcluir.setBounds(60, 180, 233, 50);
        bExcluir.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bExcluir.setFocusPainted(false);
        bExcluir.setBackground(Color.WHITE);
        bExcluir.setBorder(new LineBorder(Color.BLACK));
        bExcluir.addActionListener(this);
        bExcluir.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                bExcluir.setBounds(60, 180, 233, 50);
                sombraBExcluir.setBounds(60, 180, 233, 52);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                bExcluir.setBounds(57, 177, 238, 56);
                sombraBExcluir.setBounds(61, 180, 230, 56);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        sombraBExcluir = new JPanel();
        sombraBExcluir.setBackground(Color.GRAY);
        sombraBExcluir.setBounds(60, 180, 233, 52);

        bSair = new JButton("Sair");
        bSair.setBounds(60, 477, 233, 50);
        bSair.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bSair.setFocusPainted(false);
        bSair.setBackground(Color.decode("#ff0000"));
        bSair.setForeground(Color.WHITE);
        bSair.setBorder(new LineBorder(Color.BLACK));
        bSair.addActionListener(this);
        bSair.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                bSair.setBounds(60, 477, 233, 50);
                sombraBSair.setBounds(60, 477, 233, 52);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().requestFocus();
                bSair.setBounds(57, 474, 238, 56);
                sombraBSair.setBounds(61, 477, 230, 56);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

        sombraBSair = new JPanel();
        sombraBSair.setBackground(Color.GRAY);
        sombraBSair.setBounds(60, 477, 233, 52);

        menu = new JLabel("MENU");
        menu.setBounds(140, 10, 130, 25);
        menu.setFont(new Font("Urbandub", Font.BOLD, 20));
        menu.setForeground(Color.WHITE);

        panelMenu = new JPanel();
        panelMenu.setBackground(Color.decode("#66b3ff"));
        panelMenu.setBounds(950, 0, 350, 563);
        panelMenu.setBorder(new LineBorder(Color.BLACK));
        panelMenu.setLayout(null);

        panelMenuSombra = new JPanel();
        panelMenuSombra.setBackground(Color.LIGHT_GRAY);
        panelMenuSombra.setBounds(947, 0, 350, 563);

        separadorMenu = new JSeparator();
        separadorMenu.setBounds(50, 40, 1, 487);
        separadorMenu.setBorder(new LineBorder(Color.BLACK));

        separadorMenu2 = new JSeparator();
        separadorMenu2.setBounds(301, 40, 1, 487);
        separadorMenu2.setBorder(new LineBorder(Color.BLACK));

        panel = new JPanel();
        panel.setBackground(Color.decode("#d1e0e0"));
        panel.setLayout(null);

        panel.add(funcionarios);
        panel.add(separadorFuncionarios);

        panel.add(buscar);
        panel.add(textBuscar);
        panel.add(panelBuscar);
        panel.add(sombraBuscar);
        panel.add(separadorAtualizar);
        panel.add(bAtualizar);
        panel.add(sombraBAtualizar);

        panel.add(barra);
        panel.add(sombraBarra);

        panelMenu.add(menu);
        panelMenu.add(separadorMenu);
        panelMenu.add(separadorMenu2);
        panelMenu.add(bCadastrar);
        panelMenu.add(sombraBCadastrar);
        panelMenu.add(bAlterar);
        panelMenu.add(sombraBAlterar);
        panelMenu.add(bExcluir);
        panelMenu.add(sombraBExcluir);
        panelMenu.add(bSair);
        panelMenu.add(sombraBSair);

        panel.add(panelMenu);
        panel.add(panelMenuSombra);

        frame = new JFrame();
        frame.setTitle("Menu Principal - Gerência");
        frame.setSize(1300, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bCadastrar) {
            telaCadastroFuncionario telaCadastroFuncionario = new telaCadastroFuncionario();
        }
        
        if (e.getSource() == bAlterar) {
            telaAlterarFuncionario telaAlterarFuncionario = new telaAlterarFuncionario();
        }
        
        if (e.getSource() == bExcluir) {
            telaExcluirFuncionario telaExcluirFuncionario = new telaExcluirFuncionario();
        }
        
        if (e.getSource() == bSair) {
            frame.dispose();
        }
        
    }

    public static void main(String args[]) {

        telaPrincipalMaster telaPrincipalMaster = new telaPrincipalMaster();

    }

}
