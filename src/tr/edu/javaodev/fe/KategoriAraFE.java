package tr.edu.javaodev.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.edu.javaodev.dal.KategoriDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;

public class KategoriAraFE extends JDialog implements IFeInterfaces {

	public KategoriAraFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		add(panel);
		setTitle("Kategori Ara");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("Düzenleme Ýþlemleri"));
		JPanel ustPanel = new JPanel(new GridLayout(2, 2));

		ustPanel.setBorder(BorderFactory.createTitledBorder("Kategori Ara"));
		JLabel kategoriAdiLabel = new JLabel("Kategori Adý:", JLabel.RIGHT);
		ustPanel.add(kategoriAdiLabel);
		JTextField kategoriAdiField = new JTextField(10);
		ustPanel.add(kategoriAdiField);

	

		JList kategoriList = new JList();
		kategoriList.setListData(new KategoriDAL().GetAll().toArray());

		kategoriList.setSelectedIndex(0);

		JScrollPane pane = new JScrollPane(kategoriList);
		pane.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Liste"));

		kategoriAdiField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				kategoriList.setListData(new KategoriDAL().GetSearchKategori(kategoriAdiField.getText()).toArray());

				kategoriList.setSelectedIndex(0);
			}
			

		});

		panel.add(ustPanel, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
