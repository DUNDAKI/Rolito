package robo;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Prime extends JFrame {
	JPanel painelUpdate;
	Robot optimusPrime;

	private JLabel contagemTempo, horaTotal, update;
	private Timer tm;
	private Integer contador = 0, cont = 0, contAtualiza = 0;
	private boolean rodando = false;

	private JButton start, stop;

	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JPanel atualiza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prime frame = new Prime();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prime() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(7, 188, 300, 78);
		contentPane.add(panel);
		panel.setSize(200, 78);

		contagemTempo = new JLabel("00:00:00");
		panel.add(contagemTempo);
		contagemTempo.setFont(new Font(contagemTempo.getName(), Font.PLAIN, 50));

		painelUpdate = new JPanel();
		painelUpdate.setBounds(7, 32, 200, 53);
		contentPane.add(painelUpdate);
		painelUpdate.setSize(200, 78);

		horaTotal = new JLabel("00:00:00");
		painelUpdate.add(horaTotal);
		horaTotal.setFont(new Font(horaTotal.getName(), Font.PLAIN, 50));

		atualiza = new JPanel();
		atualiza.setBounds(250, 191, 151, 75);
		contentPane.add(atualiza);

		update = new JLabel("00");
		atualiza.add(update);
		update.setFont(new Font(update.getName(), Font.PLAIN, 50));

		JLabel lblNewLabel = new JLabel("Monitoramento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(7, 157, 200, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Monitoramento Total");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(7, 7, 200, 14);
		contentPane.add(lblNewLabel_1);

		start = new JButton("Start");
		start.setBounds(220, 31, 110, 33);
		contentPane.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!rodando) {
					rodando = true;
					tm = new Timer();
					tm.scheduleAtFixedRate(new TimerTask() {

						@Override
						public void run() {
							contador++;
							cont++;

							int seg = contador % 60;
							int min = contador / 60;
							int hora = min / 60;
							min %= 60; // fica somente os minutos
							contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg));// altera a label da
																									// contagem de tempo
							// monitoramento total
							int seg2 = cont % 60;
							int min2 = cont / 60;
							int hora2 = min / 60;
							min %= 60; // fica somente os minutos
							horaTotal.setText(String.format("%02d:%02d:%02d", hora2, min2, seg2));// altera a label da

							update.setText(String.format("%02d", contAtualiza));// quantidade de atualizaçoes

							if (hora == 1) {
								try {
									contador = 0;
									contAtualiza++;
									upateCrono();
								} catch (AWTException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							;
						}
					}, 1000, 1000);
					// TODO Auto-generated method stub
				}

			}
		});

		lblNewLabel_2 = new JLabel("Total de Atualiza\u00E7oes");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(250, 159, 151, 21);
		contentPane.add(lblNewLabel_2);

		stop = new JButton("Stop");
		stop.setBounds(220, 76, 110, 33);
		contentPane.add(stop);
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rodando) {
					tm.cancel();
					rodando = false;
					contador = 0;
					cont = 0;
				}
			}
		});

	}

	public void upateCrono() throws AWTException {

		Robot optimusPrime;
		optimusPrime = new Robot();
		optimusPrime.setAutoDelay(1000);

		optimusPrime.mouseMove(1225, 445);

		optimusPrime.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		optimusPrime.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		optimusPrime.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		optimusPrime.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		System.out.println("Numero de Atualizações: " + contAtualiza);

	}

}
