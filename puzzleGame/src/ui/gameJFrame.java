package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;

public class gameJFrame extends JFrame implements KeyListener,MouseListener {
    int[][] data = new int[4][4];
    String path="E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\sport\\sport3\\";
    int x0, y0;
    long step = 0;
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem wechatItem = new JMenuItem("我的微信");
    JMenuItem inmoney = new JMenuItem("充值入口");
    JMenuItem animal=new JMenu("动物");
    JMenuItem sport=new JMenu("运动");
    JMenuItem girl=new JMenu("美女");


    public gameJFrame() {
        initJFrame();
        initJMune();
        initData();
        initImage();
        this.setVisible(true);
    }

    private void initData() {
        Random random = new Random();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int indexElement = arr[index];
            arr[index] = arr[i];
            arr[i] = indexElement;
        }
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = arr[k];
                if (data[i][j] == 0) {
                    x0 = i;
                    y0 = j;
                }
                k++;
            }
        }
    }

    private void initImage() {
        this.getContentPane().removeAll();

        if (isWin()) {
            JLabel win = new JLabel(new ImageIcon("E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\win.png"));
            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //设置拼图边框
                jLabel.setBorder(new BevelBorder(0));
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bg = new ImageIcon("E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\background.png");
        JLabel bgJLable = new JLabel(bg);
        bgJLable.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bgJLable);
        this.getContentPane().repaint();
    }

    public void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图游戏单机版 v1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    public void initJMune() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu function = new JMenu("功能");
        JMenu about = new JMenu("关于我们");
        JMenu money = new JMenu("充值");
        JMenu changeImage=new JMenu("更换图片");

        replayItem.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                step=0;
                initData();
                initImage();
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        reLoginItem.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                gameJFrame.super.setVisible(false);
                new loginJFrame();
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        closeItem.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        wechatItem.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                JDialog Jd=new JDialog();
                JLabel jl=new JLabel(new ImageIcon("E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\微信码.jpg"));
                jl.setBounds(0,0,539,542);
                Jd.setSize(580,580);
                Jd.setAlwaysOnTop(true);
                Jd.setModal(true);
                Jd.setLocationRelativeTo(null);
                Jd.getContentPane().add(jl);
                Jd.setVisible(true);
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        inmoney.addMouseListener(new MouseListener() {
            @Override public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                JDialog Jd=new JDialog();
                JLabel jl=new JLabel(new ImageIcon("E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\付款码.jpg"));
                jl.setBounds(0,0,528,564);
                Jd.setSize(570,570);
                Jd.setAlwaysOnTop(true);
                Jd.setModal(true);
                Jd.setLocationRelativeTo(null);
                Jd.getContentPane().add(jl);
                Jd.setVisible(true);
            }
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        });
        sport.addMouseListener(this);
        girl.addMouseListener(this);
        animal.addMouseListener(this);

        jMenuBar.add(function);
        jMenuBar.add(about);
        jMenuBar.add(money);
        function.add(changeImage);
        changeImage.add(animal);
        changeImage.add(sport);
        changeImage.add(girl);
        function.add(replayItem);
        function.add(reLoginItem);
        function.add(closeItem);
        about.add(wechatItem);
        money.add(inmoney);
        this.setJMenuBar(jMenuBar);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            this.getContentPane().removeAll();
            JLabel jl = new JLabel(new ImageIcon(path+"all.jpg"));
            jl.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jl);
            ImageIcon bg = new ImageIcon("E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\background.png");
            JLabel bgJLable = new JLabel(bg);
            bgJLable.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bgJLable);
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (isWin()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == 37) {
            if ((1 + y0) < 4) {
                data[x0][y0] = data[x0][y0 + 1];
                data[x0][y0 + 1] = 0;
                y0++;
                step++;
            }

        } else if (code == 38) {
            if ((x0 + 1) < 4) {
                data[x0][y0] = data[x0 + 1][y0];
                data[x0 + 1][y0] = 0;
                x0++;
                step++;
            }

        } else if (code == 39) {
            if ((y0 - 1) >= 0) {
                data[x0][y0] = data[x0][y0 - 1];
                data[x0][y0 - 1] = 0;
                y0--;
                step++;
            }

        } else if (code == 40) {
            if ((x0 - 1) >= 0) {
                data[x0][y0] = data[x0 - 1][y0];
                data[x0 - 1][y0] = 0;
                x0--;
                step++;
            }
        } else if (code == 61) {
            data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
            x0 = 3;
            y0 = 3;
            step = 99;
        }
        initImage();
    }

    public boolean isWin() {
        int[][] arrWin = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != arrWin[i][j])
                    return false;
            }
        }
        return true;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object ob=e.getSource();
        if(ob==sport)
        {
            Random ran=new Random();
            int i=ran.nextInt(10)+1;
            path="E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\sport\\sport"+i+"\\";
            initData();
            initImage();
        }
        else if(ob==animal)
        {
            Random ran=new Random();
            int i=ran.nextInt(8)+1;
            path="E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\animal\\animal"+i+"\\";
            initData();
            initImage();
        }
        else if(ob==girl)
        {
            Random ran=new Random();
            int i=ran.nextInt(10)+1;
            path="E:\\程序\\JAVA\\PuzzleGame\\puzzleGame\\image\\girl\\girl"+i+"\\";
            initData();
            initImage();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
//here
//a try
//2