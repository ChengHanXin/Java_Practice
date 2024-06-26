package com.xaut.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //用于存储打乱后图片的编号
    int[][] data = new int[4][4];

    //用于记录空白方格的位置
    int x = 0, y = 0;

    //用于记录图片位置
    String path = "puzzlegame/image/animal/animal3/";

    //用于记录胜利图片位置
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //统计步数
    int step = 0;

    JMenuItem replayItem;
    JMenuItem reLoginItem;
    JMenuItem closeItem;
    JMenuItem accountItem;
    JMenuItem beautyItem;
    JMenuItem animalItem;
    JMenuItem sportItem;

    public GameJFrame() {
        init();

        initMenu();

        initData();

        initImage();

        //让界面显示出来，建议写在最后
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //打乱一维数组
        Random rand = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int randIndex = rand.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[randIndex];
            tempArr[randIndex] = temp;
        }

        //将一维数组的值赋给二维数组
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }

    private void initImage() {
        //清空原本已经出现的所有照片
        this.getContentPane().removeAll();

        //如果游戏胜利，加载胜利图标
        if (victory()){
            JLabel winJLabel = new JLabel(new ImageIcon("puzzlegame/image/win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        //布局步数
        JLabel stepJLabel = new JLabel("步数" + step);
        stepJLabel.setBounds(50,30,100,20);
        this.getContentPane().add(stepJLabel);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
//                System.out.println(path + num +".jpg");
                // 创建 ImageIcon 对象，用来存储图片
                ImageIcon imageIcon = new ImageIcon(path + num +".jpg");

                // 使用 JLabel 对象管理 ImageIcon
                JLabel imageLabel = new JLabel(imageIcon);

                // 设置 JLabel 的位置和大小
                imageLabel.setBounds(105 * j + 83, 105 * i + 134, imageIcon.getIconWidth(), imageIcon.getIconHeight());

                //给图片添加边框
                //0:表示让图片凸起来
                //1：表示让图片凹下去
                imageLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                // 将 JLabel 对象添加到界面当中
                this.getContentPane().add(imageLabel);
            }
        }

        //加载背景图片  先加载的图片显示在上层
        ImageIcon bg = new ImageIcon("puzzlegame/image/background.png");
        JLabel backgroundLabel = new JLabel(bg);
        backgroundLabel.setBounds(40, 40, bg.getIconWidth(), bg.getIconHeight());
        this.getContentPane().add(backgroundLabel);

        //刷新照片
        this.getContentPane().repaint();
    }


    private void initMenu() {
        //设置菜单栏
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项对象（功能、关于我们、更换图片）
        JMenu fuctionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeJMenu = new JMenu("更换图片");


        //创建选项下面的条目对象
        replayItem = new JMenuItem("重新游戏");
        reLoginItem = new JMenuItem("重新登录");
        closeItem = new JMenuItem("关闭游戏");

        accountItem = new JMenuItem("公众号");

        beautyItem = new JMenuItem("美女");
        animalItem = new JMenuItem("动物");
        sportItem = new JMenuItem("运动");



        //将每一个条目添加到对应的选项对象中
        changeJMenu.add(beautyItem);
        changeJMenu.add(animalItem);
        changeJMenu.add(sportItem);

        fuctionJMenu.add(changeJMenu);
        fuctionJMenu.add(replayItem);
        fuctionJMenu.add(reLoginItem);
        fuctionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);



        //为每个条目添加事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        beautyItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);


        //将两个选项添加到菜单对象中
        jMenuBar.add(fuctionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
        this.addKeyListener(this);
    }

    private void init() {
        //设置界面的宽高
        this.setSize(603, 680);
        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //清空当前窗口所有图片
            this.getContentPane().removeAll();
            //按住A不松时，查看完整图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            ImageIcon bg = new ImageIcon("puzzlegame/image/background.png");
            JLabel backgroundLabel = new JLabel(bg);
            backgroundLabel.setBounds(40, 40, bg.getIconWidth(), bg.getIconHeight());
            this.getContentPane().add(backgroundLabel);
            //刷新页面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //如果已经胜利，则不允许接着移动
        if (victory()){
            return;
        }

        //对上，下，左，右进行判断
        //左：37 上：38 右：39 下：40
        int code = e.getKeyCode();

        if (code == 38){
            //向上移动
            //空白区域下方的图像上移
            //当空白区域在最下方时，无法完成上移
            if (x == 3){
                return;
            }
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            //移动一次，步数加一
            step++;
            //再次调用initImage()方法，重新加载移动后的图像
            initImage();
        } else if (code == 40){
            //向下移动
            //空白区域上方的图像下移
            //当空白区域在最上方时，无法完成下移
            if (x == 0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            //移动一次，步数加一
            step++;
            //再次调用initImage()方法，重新加载移动后的图像
            initImage();
        } else if (code == 37){
            //向左移动
            //空白区域右方的图像左移
            //当空白区域在最右方时，无法完成左移
            if (y == 3){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            //移动一次，步数加一
            step++;
            //再次调用initImage()方法，重新加载移动后的图像
            initImage();
        } else if (code == 39){
            //向右移动
            //空白区域左方的图像右移
            //当空白区域在最左方时，无法完成右移
            if (y == 0){
                return;
            }
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            //移动一次，步数加一
            step++;
            //再次调用initImage()方法，重新加载移动后的图像
            initImage();
        } else if(code == 65){
            //松开之后，重新加载图片
            initImage();
        } else if(code == 87){
            //按下w，一键通关，并显示完整图片
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
            x = 3;
            y = 3;
        }
    }

    public boolean victory(){
        //判断当前游戏是否胜利
        for (int i = 0; i < win.length; i++) {
            for (int j = 0; j < win.length; j++){
                if (win[i][j] != data[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == replayItem){
            //重新开始游戏
            //清空步数
            step = 0;
            //重新打乱数据
            initData();
            //初始化界面
            initImage();
        } else if (obj == reLoginItem){
            //重新登录
            this.setVisible(false);
            new LoginJFrame();
        } else if (obj == closeItem){
            //关闭游戏
            System.exit(0);
        } else if (obj == accountItem){
            //关于我们
            //创建一个弹框对象
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame/image/about.png"));
            //设置位置和宽高
            jLabel.setBounds(0,0,258,258);
            //把图片添加到弹框当中
            jDialog.getContentPane().add(jLabel);
            //给弹框设置大小
            jDialog.setSize(344,344);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        } else if (obj == beautyItem){
            //切换美女照片
            //清空步数
            step = 0;
            //更新图片路径
            Random random = new Random();
            int randomIndex = random.nextInt(13) + 1;
            path = "puzzlegame/image/girl/girl" + randomIndex + "/";
            //重新打乱数据
            initData();
            //初始化界面
            initImage();
        } else if (obj == animalItem){
            //切换动物照片
            //清空步数
            step = 0;
            //更新图片路径
            Random random = new Random();
            int randomIndex = random.nextInt(8) + 1;
            path = "puzzlegame/image/animal/animal" + randomIndex + "/";
            //重新打乱数据
            initData();
            //初始化界面
            initImage();
        } else if (obj == sportItem) {
            //切换运动照片
            //清空步数
            step = 0;
            //更新图片路径
            Random random = new Random();
            int randomIndex = random.nextInt(8) + 1;
            path = "puzzlegame/image/sport/sport" + randomIndex + "/";
            //重新打乱数据
            initData();
            //初始化界面
            initImage();
        }
    }
}
