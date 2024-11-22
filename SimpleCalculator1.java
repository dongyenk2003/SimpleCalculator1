import javax.swing.*; // For GUI components
import java.awt.event.*; // For ActionListener interface

public class SimpleCalculator1 extends JFrame implements ActionListener{
    /*Inheriting JFrame means not having to explicitly create a JFrame instance.

    * Implementing ActionListener means not having the awkward verbose
    * SwingComponent.addActionListener( new ActionEvent() ... )* code for every Swing Component I want to
    * add an Action Listener to.
    */

    // Declaring variables for components which will be part of this JFrame subclass instance.
    JTextField numberInputField1, numberInputField2, numberOutputField1;
    JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton;

    public SimpleCalculator1(){ // Default constructor method
        this.setupFrame();
        this.setupTextFields();
        this.setupButtons();

        this.setVisible( true ); // call last so all added Components are drawn.
    }

    private void setupFrame(){
        this.setTitle( "Simple Calculator 1" );
        this.setSize( 800, 350 );
        this.setLayout( null ); // No layout manager means absolute positions are used. I assume this means no responsove design type UI.
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE ); // End program when red X is clicked.
    }

    private void setupTextFields(){
        numberInputField1 = new JTextField();
        numberInputField1.setBounds( 50, 50, 100, 50 );
        this.add( numberInputField1 );

        numberInputField2 = new JTextField();
        numberInputField2.setBounds( 200, 50, 100, 50 );
        this.add( numberInputField2 );

        numberOutputField1 = new JTextField();
        numberOutputField1.setBounds( 50, 250, 200, 50 );
        numberOutputField1.setEditable( false );
        this.add( numberOutputField1 );
    }

    private void setupButtons(){
        addButton = new JButton( "+" );
        addButton.setBounds( 50, 150, 50, 50 );
        addButton.addActionListener( this ); // Sends an ActionEvent object to the ActionListener interface's actionPerformed method.
        this.add( addButton );

        subtractButton = new JButton( "-" );
        subtractButton.setBounds( 150, 150, 50, 50 );
        subtractButton.addActionListener( this );
        // less verbose than typing addActionListener( new ActionEvent(...) )
        this.add( subtractButton );

        multiplyButton = new JButton( "*" );
        multiplyButton.setBounds( 250, 150, 50, 50 );
        /*multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });*/
        multiplyButton.addActionListener( this );
        this.add( multiplyButton );

        divideButton = new JButton( "/" );
        divideButton.setBounds( 350, 150, 50, 50 );
        divideButton.addActionListener( this );
        this.add( divideButton );

        moduloButton = new JButton( "%" );
        moduloButton.setBounds( 450, 150, 50, 50 );
        moduloButton.addActionListener( this );
        this.add( moduloButton );
    }

    public static void main( String[] args ){
        new SimpleCalculator1();
    }



    @Override // Implements
    public void actionPerformed( ActionEvent e ){
        /* When a Component instance has an ActionListener added to it, it fires off an
        * ActionEvent object which is caught by this method. Check the source of the ActionEvent object
        * in order to respond accordingly to user inputs. */

        // Try to read in user Integer inputs. Regardless of the ActionEvent instance's source.
        float numberInput1;
        float numberInput2;
        float result = 0;

        try {
            numberInput1 = Float.parseFloat(numberInputField1.getText());
            numberInput2 = Float.parseFloat(numberInputField2.getText());

            // Do different things to the inputs depending on what button was pressed (What is the source of the ActionEvent?)
           if( e.getSource().equals( this.addButton ) ){
               result = numberInput1 + numberInput2;
           }else if( e.getSource().equals( this.subtractButton ) ){
               result = numberInput1 - numberInput2;
           }else if( e.getSource().equals( this.multiplyButton ) ){
               result = numberInput1 * numberInput2;
           }else if( e.getSource().equals( this.divideButton ) ){
               result = numberInput1 / numberInput2;
           }else if( e.getSource().equals( this.moduloButton ) ){
               result = numberInput1 % numberInput2;
           }

           this.numberOutputField1.setText( String.valueOf( result ) );

        }catch( NumberFormatException numberFormatException ){
            numberOutputField1.setText( "Numerical inputs only!" );
        }

    }

}
