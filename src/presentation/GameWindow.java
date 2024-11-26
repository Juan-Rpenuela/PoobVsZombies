package presentation;

import domain.board.Board;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private JPanel boardPanel;
    private JLabel sunCounter;
    private Board board;

    public GameWindow(int rows, int cols) {
        setTitle("POOB VS Zombies");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Tablero
        boardPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                final int row = i; // Capturar i en una variable efectivamente final
                final int col = j; // Capturar j en una variable efectivamente final
                JButton cell = new JButton();
                cell.setBackground(Color.GREEN);
                cell.addActionListener(e -> System.out.println("Clicked: (" + row + ", " + col + ")"));
                boardPanel.add(cell);
            }
        }
        add(boardPanel, BorderLayout.CENTER);

        // Panel lateral
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sunCounter = new JLabel("Soles: 0");
        sidePanel.add(sunCounter);

        JButton plantButton = new JButton("Plantar Girasol");
        plantButton.addActionListener(e -> System.out.println("Plantar Girasol seleccionado"));
        sidePanel.add(plantButton);

        add(sidePanel, BorderLayout.EAST);

        setVisible(true);
    }

    public void updateSunCounter(int sunPoints) {
        sunCounter.setText("Soles: " + sunPoints);
    }

    public static void main(String[] args) {
        new GameWindow(5, 9); // Tablero de 5x9
    }
    public void updateBoard(Board board) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                JButton cell = (JButton) boardPanel.getComponent(i * board.getColumns() + j);
                Point position = new Point(j, i);

                // Actualizar la celda según el estado del tablero
                if (board.getPlantAt(position) != null) {
                    cell.setText("P"); // Representa una planta
                    cell.setBackground(Color.GREEN);
                } else if (board.getZombieAt(position) != null) {
                    cell.setText("Z"); // Representa un zombi
                    cell.setBackground(Color.RED);
                } else {
                    cell.setText(""); // Celda vacía
                    cell.setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }
    public void updateSunCounter() {
        sunCounter.setText("Soles: " + board.getSunPoints());
    }

}