import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class tictactoe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons= new JButton[9];
    boolean player1;

    tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        /*label the heading*/
        textfield.setBackground(Color.black );
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Times New Roman", Font.BOLD, 80));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);
        textfield.setText("Tic-Tac-Toe");
        /*adding to title panel */
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);
        titlePanel.add(textfield);
        /*boxes for playing */
        buttonPanel.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
        frame.add(buttonPanel);
        firstTurn();
        frame.add(textfield,BorderLayout.NORTH);
    }
    public static void main(String[] args) {
        tictactoe t = new tictactoe();
    }

    public void firstTurn(){
        // try {
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        if(random.nextInt(2)==0){
            player1=true;
            textfield.setText("X Turn");
        }
        else{ player1=false;
        textfield.setText("O Turn");}
    }
    public void check(){
        /*X win */
        /*horizontally */
        if(buttons[0].getText() == "X" && buttons[1].getText()=="X" && buttons[2].getText()=="X"){
            xWins(0, 1, 2);
        }
        if(buttons[3].getText() == "X" && buttons[4].getText()=="X" && buttons[5].getText()=="X"){
            xWins(3, 4, 5);
        }
        if(buttons[6].getText() == "X" && buttons[7].getText()=="X" && buttons[8].getText()=="X"){
            xWins(6 , 7, 8);
        }
        /*vetically */
        if(buttons[0].getText() == "X" && buttons[3].getText()=="X" && buttons[6].getText()=="X"){
            xWins(0 , 3, 6);
        }
        if(buttons[1].getText() == "X" && buttons[4].getText()=="X" && buttons[7].getText()=="X"){
            xWins(1 , 4, 7);
        }
        if(buttons[2].getText() == "X" && buttons[5].getText()=="X" && buttons[8].getText()=="X"){
            xWins(2 , 5, 8);
        }
        /*diagnolly */
        if(buttons[0].getText() == "X" && buttons[4].getText()=="X" && buttons[8].getText()=="X"){
            xWins(0, 4, 8);
        }
        if(buttons[2].getText() == "X" && buttons[4].getText()=="X" && buttons[6].getText()=="X"){
            xWins(2, 4, 6);
        }
        /* O Wins */
        /*horizontally */
        if(buttons[0].getText() == "O" && buttons[1].getText()=="O" && buttons[2].getText()=="O"){
            oWins(0, 1, 2);
        }
        if(buttons[3].getText() == "O" && buttons[4].getText()=="O" && buttons[5].getText()=="O"){
            oWins(3, 4, 5);
        }
        if(buttons[6].getText() == "O" && buttons[7].getText()=="O" && buttons[8].getText()=="O"){
            oWins(6 , 7, 8);
        }
        /*vetically */
        if(buttons[0].getText() == "O" && buttons[3].getText()=="O" && buttons[6].getText()=="O"){
            oWins(0 , 3, 6);
        }
        if(buttons[1].getText() == "O" && buttons[4].getText()=="O" && buttons[7].getText()=="O"){
            oWins(1 , 4, 7);
        }
        if(buttons[2].getText() == "O" && buttons[5].getText()=="O" && buttons[8].getText()=="O"){
            oWins(2 , 5, 8);
        }
        /*diagnolly */
        if(buttons[0].getText() == "O" && buttons[1].getText()=="O" && buttons[2].getText()=="O"){
            oWins(0, 1, 2);
        }
        if(buttons[0].getText() == "O" && buttons[4].getText()=="O" && buttons[8].getText()=="O"){
            oWins(0, 4, 8);
        }
        if(buttons[2].getText() == "O" && buttons[4].getText()=="O" && buttons[6].getText()=="O"){
            oWins(2, 4, 6);
        }
    }
    public void xWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }
    public void oWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0;i<9;i++){
            if (e.getSource()==buttons[i])
            {
                if(player1){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1=false;
                        textfield.setText("O Turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1=true;
                        textfield.setText("X Turn");
                        check();
                    }
                }
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
    