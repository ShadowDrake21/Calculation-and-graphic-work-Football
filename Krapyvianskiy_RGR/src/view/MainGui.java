package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import model.Amplua;
import model.AnyData;
import model.Club;
import model.Footballer;
import model.League;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainGui {

	private JFrame frame;
	private JTree tree;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnEdit;
	private JButton btnStore;
	private JButton btnRestore;
	private JButton btnCalculate;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEvent;
	private JMenuItem mntmStore;
	private JMenuItem mntmRestore;
	private JMenuItem mntmAddListener;
	private JMenuItem mntmRemoveListener;
	private JPopupMenu popupMenu;
	private JMenuItem mntmTheMostExpensivePlayer;
	private JMenuItem mntmNumberOfKeyPos;
	List<IOperationsListener> operationsListener = new CopyOnWriteArrayList<>();
	private JMenuItem mntmShowProtocol;
	private JMenuItem mntmClearProtocol;
	private JScrollPane scrollPane_Console;
	private JTextArea textAreaConsole;
	private JLabel lblConsole;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				onWindowOpened();
			}
		});
		frame.setTitle("\u0420\u0413\u0420 \"\u0423\u041F\u041B\"");
		frame.setBounds(100, 100, 370, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 571, -5, 0 };
		gridBagLayout.rowHeights = new int[] { 227, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onShow(e);
			}
		});
		tree.setPreferredSize(new Dimension(80, 72));
		tree.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(tree);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("Add");
		btnAdd.setMargin(new Insets(2, 10, 2, 10));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAdd();
			}
		});
		btnAdd.setPreferredSize(new Dimension(110, 26));
		panel.add(btnAdd);

		btnRemove = new JButton("Remove");
		btnRemove.setMargin(new Insets(2, 10, 2, 10));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRemove();
			}
		});
		btnRemove.setPreferredSize(new Dimension(110, 26));
		panel.add(btnRemove);

		btnEdit = new JButton("Edit");
		btnEdit.setMargin(new Insets(2, 10, 2, 10));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEdit();
			}
		});
		btnEdit.setPreferredSize(new Dimension(110, 26));
		panel.add(btnEdit);

		btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		btnStore.setMargin(new Insets(2, 10, 2, 10));
		btnStore.setPreferredSize(new Dimension(110, 26));
		panel.add(btnStore);

		btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestore();
			}
		});
		btnRestore.setMargin(new Insets(2, 10, 2, 10));
		btnRestore.setPreferredSize(new Dimension(110, 26));
		panel.add(btnRestore);

		btnCalculate = new JButton("Find/Calculate");
		btnCalculate.setMargin(new Insets(2, 10, 2, 10));
		btnCalculate.setPreferredSize(new Dimension(110, 26));
		panel.add(btnCalculate);

		popupMenu = new JPopupMenu();
		addPopup(btnCalculate, popupMenu);

		mntmTheMostExpensivePlayer = new JMenuItem("The most expensive footballer");
		mntmTheMostExpensivePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSearch();
			}
		});
		popupMenu.add(mntmTheMostExpensivePlayer);

		mntmNumberOfKeyPos = new JMenuItem("Number of key positions");
		mntmNumberOfKeyPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCalculate();
			}
		});
		popupMenu.add(mntmNumberOfKeyPos);
		
		scrollPane_Console = new JScrollPane();
		GridBagConstraints gbc_scrollPane_Console = new GridBagConstraints();
		gbc_scrollPane_Console.gridwidth = 2;
		gbc_scrollPane_Console.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_Console.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Console.gridx = 0;
		gbc_scrollPane_Console.gridy = 1;
		frame.getContentPane().add(scrollPane_Console, gbc_scrollPane_Console);
		
		textAreaConsole = new JTextArea();
		scrollPane_Console.setViewportView(textAreaConsole);
		
		lblConsole = new JLabel("Console");
		lblConsole.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_Console.setColumnHeaderView(lblConsole);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmStore = new JMenuItem("Store");
		mntmStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		mnFile.add(mntmStore);

		mntmRestore = new JMenuItem("Restore");
		mntmRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestore();
			}
		});
		mnFile.add(mntmRestore);
		
		mntmShowProtocol = new JMenuItem("Show Protocol");
		mntmShowProtocol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onShowProtocol();
			}
		});
		mnFile.add(mntmShowProtocol);
		
		mntmClearProtocol = new JMenuItem("Clear Protocol");
		mntmClearProtocol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearProtocol();
			}
		});
		mnFile.add(mntmClearProtocol);

		mnEvent = new JMenu("Event");
		menuBar.add(mnEvent);

		mntmAddListener = new JMenuItem("Add Listener");
		mntmAddListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAddListener();
			}
		});
		mnEvent.add(mntmAddListener);

		mntmRemoveListener = new JMenuItem("Remove Listener");
		mntmRemoveListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeOperationListener();
			}
		});
		mnEvent.add(mntmRemoveListener);
	}

	protected TreeModel getStartModel() throws Exception {
		League l = new League("Українська Прем'єр-ліга", "Томас Грім", 4, 500);
		Club c = new Club("Шахтар Донецьк", "Ігор Йовичевич", 2, 200);
		Amplua a = new Amplua("Воротар", "Відмінна реакція", true);
		Footballer f = new Footballer("П'ятов А.В.", "Воротар", LocalDate.parse("1984-06-28"), "Українець", 10, true);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode(l);
		DefaultMutableTreeNode cNod = new DefaultMutableTreeNode(c);
		DefaultMutableTreeNode aNod = new DefaultMutableTreeNode(a);
		DefaultMutableTreeNode fNod = new DefaultMutableTreeNode(f);

		root.add(cNod);
		cNod.add(aNod);
		aNod.add(fNod);
		return (new JTree(root)).getModel();
	}

	protected void onWindowOpened() {
		try {
			tree.setModel(getStartModel());

			for (int i = 0; i < tree.getRowCount(); i++)
				tree.expandRow(i);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private DefaultMutableTreeNode getSelectedNode() {
		Object selectNode = tree.getLastSelectedPathComponent();
		if (selectNode == null) {
			JOptionPane.showMessageDialog(tree, "Node was not selected", frame.getTitle(), JOptionPane.ERROR_MESSAGE);
			return null;
		}

		return (DefaultMutableTreeNode) selectNode;
	}

	private void expandAll() {
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	private void selectNode(DefaultMutableTreeNode node) {
		int n = 0;
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		Enumeration<DefaultMutableTreeNode> enm = root.children();
		while (enm.hasMoreElements()) {
			DefaultMutableTreeNode nod = enm.nextElement();

			if (nod == node) {
				tree.setSelectionRow(n);
				return;
			}
			n++;
		}
	}

	private void onShow(MouseEvent e) {
		if (e.getClickCount() != 3 || e.getButton() != MouseEvent.BUTTON3)
			return;
		DefaultMutableTreeNode node = getSelectedNode();

		if (node == null) {
			return;
		}

		AnyData data = (AnyData) node.getUserObject();
		IDlg dlg = data.getDialog();
		dlg.showObject(data, false);
		dlg.dispose();
	}

	protected void onAdd() {
		DefaultMutableTreeNode parent = getSelectedNode();
		if (parent == null) {
			return;
		}
		AnyData parentData = (AnyData) parent.getUserObject();
		IDlg dlg = parentData.getSonDialog();
		if (dlg == null) {
			return;
		}
		dlg.showObject(null, true);
		AnyData obj = dlg.getObject();
		dlg.dispose();
		if (obj == null) {
			return;
		}
		DefaultMutableTreeNode newSon = new DefaultMutableTreeNode(obj);
		parent.add(newSon);
		tree.updateUI();
		expandAll();
		fireOperationEvent(obj, "Додавання");
	}

	protected void onRemove() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null) {
			return;
		}
		if (node.isRoot()) {
			tree.setModel(null);
		}
		node.removeFromParent();
		AnyData data = (AnyData) node.getUserObject();
		tree.setSelectionPath(null);
		tree.updateUI();
		fireOperationEvent(data, "Видалення");
	}

	protected void onEdit() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null) {
			return;
		}
		AnyData data = (AnyData) node.getUserObject();
		IDlg dlg = data.getDialog();
		dlg.showObject(data, true);
		AnyData obj = dlg.getObject();
		dlg.dispose();
		if (obj == null) {
			return;
		}

		node.setUserObject(obj);
		tree.updateUI();
		fireOperationEvent(obj, "Редагування");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showMenu(e);
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	protected void onSearch() {
		DefaultMutableTreeNode node = getSelectedNode();
		if (node == null) {
			return;
		}
		float maxTransferValue = 0;
		DefaultMutableTreeNode mostExpensive = null;
		Enumeration<DefaultMutableTreeNode> enm = node.postorderEnumeration();

		while (enm.hasMoreElements()) {
			DefaultMutableTreeNode currentNode = enm.nextElement();
			Object data = currentNode.getUserObject();
			if (!(data instanceof Footballer))
				continue;
			float transferValue = ((Footballer) data).getTransferValue();
			if (transferValue > maxTransferValue) {
				maxTransferValue = transferValue;
				mostExpensive = currentNode;
			}
		}

		textAreaConsole.append("Most expensive footballer is " + mostExpensive + "\n");
		selectNode(mostExpensive);
		AnyData data = (AnyData) mostExpensive.getUserObject();
		IDlg dlg = data.getDialog();
		dlg.showObject(data, false);
		dlg.dispose();

		fireOperationEvent(data, "Пошук");
	}

	private void onCalculate() {
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();

		Enumeration<DefaultMutableTreeNode> enmClb = root.children();
		while (enmClb.hasMoreElements()) {
			DefaultMutableTreeNode clb = enmClb.nextElement();
			int nKey = 0;

			Enumeration<DefaultMutableTreeNode> enmAmpl = clb.children();
			while (enmAmpl.hasMoreElements()) {
				DefaultMutableTreeNode ampl = enmAmpl.nextElement();
				Object data = ampl.getUserObject();
				if (((Amplua) data).isKeyPosition()) {
					nKey++;
				}
			}
			
			textAreaConsole.append(clb + " has " + nKey + " key positions\n");
		}
		fireOperationEvent(null, "Розрахунок");
	}

	public void addOperationListener(IOperationsListener listener) {
		operationsListener.add(listener);
	}

	public void removeOperationListener() {
		operationsListener.clear();
	}

	public void fireOperationEvent(AnyData name, String operation) {
		OperEvent e = new OperEvent(this, operation, name);
		for (IOperationsListener x : operationsListener) {
			x.onOperationsEvent(e);
		}
	}

	public void onAddListener() {
		IOperationsListener pLis = new IOperationsListener() {
			@Override
			public void onOperationsEvent(OperEvent e) {
				textAreaConsole.append(e.toString() + "\n");
				writeString(e.toString());
			}
		};
		addOperationListener(pLis);
	}
	
	private void onStore() {
		if (tree.getModel() == null) {
			return;
		}
		JFileChooser fileChooser = new JFileChooser("Серіалізація моделі дерева");
		fileChooser.showSaveDialog(frame);
		try {
			File f = fileChooser.getSelectedFile();
			String fName = f.getAbsolutePath();
			FileOutputStream fileStream = new FileOutputStream(fName);
			ObjectOutputStream out = new ObjectOutputStream(fileStream);
			out.writeObject(tree.getModel());
			out.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(tree, "Помилка відкриття файлу", "Збереження дерева у файлі", JOptionPane.ERROR_MESSAGE);
			return;
		}
		tree.setModel((new JTree()).getModel());
		fireOperationEvent(null, "Серіалізація моделі дерева");
	}
	
	private void onRestore() {
		FileDialog fileDialog = new FileDialog(frame);
		fileDialog.setMode(FileDialog.LOAD);
		fileDialog.setVisible(true);
		String dr = fileDialog.getDirectory();
		String fn = fileDialog.getFile();
		if(dr == null || fn == null) {
			return;
		}
		String fName = dr + fn;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName));
			TreeModel model = (TreeModel) in.readObject();
			tree.setModel(model);
			in.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(tree, "Помилка десеріалізації дерева", "Десеріалізація", JOptionPane.ERROR_MESSAGE);
			return;
		}
		expandAll();
		fireOperationEvent(null, "Десеріалізація моделі дерева");
	}
	
	protected void writeString(String strLog) {
		BufferedWriter writer;
		try {
			File file = new File("RGRLogKrapyvianskyi.txt");
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(strLog);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void onShowProtocol() {
		BufferedReader reader = null;
		try {
			textAreaConsole.append("\nПротокол подій:\n");
			reader = new BufferedReader(new FileReader("RGRLogKrapyvianskyi.txt"));
			String s;
			while ((s = reader.readLine()) != null) {
				textAreaConsole.append(s + "\n");
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		fireOperationEvent(null, "Виведення протоколу на консоль");
	}

	protected void onClearProtocol() {
		File file = new File("RGRLogKrapyvianskyi.txt");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			textAreaConsole.append("Помилка при очищенні файлу: " + e.getMessage() + "\n");
		}
		fireOperationEvent(null, "Очищення протоколу");
	}
}
