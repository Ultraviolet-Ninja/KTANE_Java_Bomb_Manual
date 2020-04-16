package Game;

import Game.Mod.Attribute;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Controller {
    private static final boolean YES = true,
            NO = false,
            ODD = false,
            EVEN = true;
    private final ArrayList<ToggleGroup> allGroups = new ArrayList<>();
    private final ArrayList<SimpleWires> wireList = new ArrayList<>();
    private int step2Iterator = 0, memStage = 0;
    private StringBuilder simonColors = new StringBuilder();
    private String[] whosCurrentList;
    private final TheButton[] traits = new TheButton[2];

    @FXML
    private Button whosButtonTabBack, whosButtonTabForward,
            seqPrevRed, seqPrevBlue, seqPrevBlack, seqNextRed, seqNextBlue, seqNextBlack;

    @FXML
    private ImageView
            emptyRacket1, aT, lambda1, harryPotter, russianCat1, curvyH1, backC1,
            backEuro1, emptyRacket2, backC2, disneyQ1, hollowStar1, curvyH2, spanish1,
            copyright, leSac, disneyQ2, russianX1, not3, lambda2, hollowStar2,
            russianSix1, paragraph1, tB1, russianCat2, russianX2, spanish2, smile1,
            psi1, smile2,tB2, cDot, paragraph2, shrek3, star,
            russianSix2, backEuro2, puzzle, aeyyLmao, psi2, russianHN, ohms,
            currentPanel,
            seqRed, seqBlue, seqBlack,
            currentMaze;

    @FXML
    private Label frk, car,
            stripNumTop, stripNumBottom,
            buttonLabel,
            memInstructions,
            seqLabelRed, seqLabelBlue, seqLabelBlack,
            cautionButton, cautionSimple, cautionSimon, cautionComplex;

    @FXML
    private RadioButton buttonBlue, buttonRed, buttonYellow, buttonWhite,
            abort, press, hold, detonate,
            mazeTop, mazeBottom, mazeLetNum;

    @FXML
    private Rectangle initializer,
            stripRed, stripYellow, stripBlue, stripWhite,
            simpleWireRed, simpleWireYellow, simpleWireBlack, simpleWireBlue, simpleWireWhite;

    @FXML
    private Slider strikes,
            wireCounter;

    @FXML
    private TextArea passwordResults,
            wireConfirmation,
            complexOutput,
            morseOutput;

    @FXML
    private TextField batteries,
            wireResponse,
            simonResults,
            complexInput,
            memLabel1,  memLabel2, memLabel3, memLabel4, memLabel5,
            memPos1, memPos2, memPos3, memPos4, memPos5,
            step1In, step2In, step2Out,
            password1st, password2nd, password3rd, password4th, password5th,
            morseInput,
            mazeCoords, mazeWhiteDot, mazeTarget;

    @FXML
    private ToggleButton vowel, parallelPort, lastDigit;

    //Traits methods
    @FXML
    private void toggleVowel(){
        if (vowel.isSelected()){
            vowel.setText("Yes");
            vowel.setStyle("-fx-background-color: forestgreen; -fx-text-fill: black");
            Attribute.setVowel(YES);
            cautionSimon.setOpacity(0);
        } else {
            vowel.setStyle("-fx-background-color: crimson; -fx-text-fill: seashell");
            vowel.setText("No");
            Attribute.setVowel(NO);
        }
    }

    @FXML
    private void togglePort(){
        if (parallelPort.isSelected()){
            parallelPort.setText("Yes");
            parallelPort.setStyle("-fx-background-color: forestgreen; -fx-text-fill: black");
            Attribute.setParallel(YES);
        } else {
            parallelPort.setText("None");
            Attribute.setParallel(NO);
            parallelPort.setStyle("-fx-background-color: crimson; -fx-text-fill: seashell");
        }
    }

    @FXML
    private void toggleDigit(){
        if (lastDigit.isSelected()){
            Attribute.setLastDigitEven(EVEN);
            lastDigit.setText("Even");
            lastDigit.setStyle("-fx-background-color: forestgreen; -fx-text-fill: black");
            cautionSimple.setOpacity(0);
        } else {
            Attribute.setLastDigitEven(ODD);
            lastDigit.setStyle("-fx-background-color: crimson; -fx-text-fill: seashell");
            lastDigit.setText("Odd");
        }
    }

    @FXML
    private void toggleCAR(){
        if(car.getText().isEmpty()){
            car.setText("LIT");
            Attribute.setCAR(YES);
            cautionButton.setOpacity(0);
        } else {
            car.setText("");
            Attribute.setCAR(NO);
        }
    }

    @FXML
    private void toggleFRK(){
        if(frk.getText().isEmpty()){
            frk.setText("LIT");
            Attribute.setFRK(YES);
            cautionButton.setOpacity(0);
        } else {
            frk.setText("");
            Attribute.setFRK(NO);
        }
    }

    @FXML
    private void updateBatteries(){
        if (!batteries.getText().isEmpty()){
            try {
                Attribute.setNumBatteries(
                        Integer.parseInt(batteries.getText()));

            } catch (NumberFormatException number){
                clearBatField();
                Attribute.setNumBatteries(0);
            }
        }
    }

    @FXML
    private void clearBatField(){
        batteries.setText("");
    }

    @FXML
    private void initialize(){
        for (int idx = 0; idx < 3; idx++){
            allGroups.add(new ToggleGroup());
        }

        buttonBlue.setToggleGroup(allGroups.get(RadioGroup.BUTTON_COLOR.getIdx()));
        buttonRed.setToggleGroup(allGroups.get(RadioGroup.BUTTON_COLOR.getIdx()));
        buttonWhite.setToggleGroup(allGroups.get(RadioGroup.BUTTON_COLOR.getIdx()));
        buttonYellow.setToggleGroup(allGroups.get(RadioGroup.BUTTON_COLOR.getIdx()));
        abort.setToggleGroup(allGroups.get(RadioGroup.BUTTON_LABEL.getIdx()));
        press.setToggleGroup(allGroups.get(RadioGroup.BUTTON_LABEL.getIdx()));
        hold.setToggleGroup(allGroups.get(RadioGroup.BUTTON_LABEL.getIdx()));
        detonate.setToggleGroup(allGroups.get(RadioGroup.BUTTON_LABEL.getIdx()));
        mazeTop.setToggleGroup(allGroups.get(RadioGroup.MAZE.getIdx()));
        mazeBottom.setToggleGroup(allGroups.get(RadioGroup.MAZE.getIdx()));
        mazeLetNum.setToggleGroup(allGroups.get(RadioGroup.MAZE.getIdx()));

        traits[0] = null;
        traits[1] = null;

        initializer.setDisable(true);
    }

    //Button method
    @FXML
    private void scanButtons(){
        if (buttonBlue.isSelected()){
            traits[0] = TheButton.BLUE;
        } else if (buttonRed.isSelected()){
            traits[0] = TheButton.RED;
        } else if (buttonYellow.isSelected()){
            traits[0] = TheButton.YELLOW;
        } else if (buttonWhite.isSelected()){
            traits[0] = TheButton.WHITE;
        }

        if (abort.isSelected()){
            traits[1] = TheButton.ABORT;
        } else if (press.isSelected()){
            traits[1] = TheButton.PRESS;
        } else if (detonate.isSelected()){
            traits[1] = TheButton.DETONATE;
        } else if (hold.isSelected()){
            traits[1] = TheButton.HOLD;
        }

        if (traits[0] != null && traits[1] != null){
            String goingIn = Game.Button.evaluate(traits);

            isHold(goingIn);
            buttonLabel.setText(goingIn + " the Button");
        }
    }

    private void isHold(String text){
        if (text.equals("Hold")){
            stripRed.setOpacity(0.5);
            stripBlue.setOpacity(0.5);
            stripYellow.setOpacity(0.5);
            stripWhite.setOpacity(0.5);
            stripNumTop.setOpacity(1);
            stripNumBottom.setOpacity(1);
        } else {
            stripRed.setOpacity(0);
            stripBlue.setOpacity(0);
            stripYellow.setOpacity(0);
            stripWhite.setOpacity(0);
            stripNumTop.setOpacity(0);
            stripNumBottom.setOpacity(0);
        }
    }

    //Simple Wires method
    @FXML
    private void sWirePressed(){
        StringBuilder builder = new StringBuilder();
        if (simpleWireBlack.isHover()){
            wireList.add(SimpleWires.BLACK);
        } else if (simpleWireWhite.isHover()){
            wireList.add(SimpleWires.WHITE);
        } else if (simpleWireBlue.isHover()){
            wireList.add(SimpleWires.BLUE);
        } else if (simpleWireYellow.isHover()){
            wireList.add(SimpleWires.YELLOW);
        } else if (simpleWireRed.isHover()){
            wireList.add(SimpleWires.RED);
        }

        for (SimpleWires wire : wireList){
            builder.append(wire.getLabel());
        }
        wireConfirmation.setText(builder.toString());

        if (wireList.size() == wireCounter.getValue()){
            wireResponse.setText(Simple.conditions(wireList));
            wireList.clear();
        } else {
            wireResponse.setText("");
        }
    }

    @FXML
    private void clearWires(){
        wireResponse.setText("");
        wireConfirmation.setText("");
    }

    //Keypad methods
    @FXML
    private void keyPressed(){
        if (emptyRacket1.isHover()) {
            emptyRacket1.setImage(Symbols.change(Keypads.RACKET1,
                    emptyRacket1.getImage()));
        } else if (aT.isHover()) {
            aT.setImage(Symbols.change(Keypads.A_T, aT.getImage()));
        } else if (lambda1.isHover()) {
           lambda1.setImage(Symbols.change(Keypads.STROKED_LAMBDA1,
                   lambda1.getImage()));
        } else if (harryPotter.isHover()) {
            harryPotter.setImage(Symbols.change(Keypads.HARRY_POTTER,
                    harryPotter.getImage()));
        } else if (russianCat1.isHover()) {
            russianCat1.setImage(Symbols.change(Keypads.RUSSIAN_CAT1,
                    russianCat1.getImage()));
        } else if (curvyH1.isHover()) {
            curvyH1.setImage(Symbols.change(Keypads.CURVY_H1,
                    curvyH1.getImage()));
        } else if (backC1.isHover()) {
            backC1.setImage(Symbols.change(Keypads.BACK_C1,
                    backC1.getImage()));
        } else if (backEuro1.isHover()) {
            backEuro1.setImage(Symbols.change(Keypads.REVERSE_EURO1,
                    backEuro1.getImage()));
        } else if (emptyRacket2.isHover()) {
            emptyRacket2.setImage(Symbols.change(Keypads.RACKET2,
                    emptyRacket2.getImage()));
        } else if (backC2.isHover()) {
            backC2.setImage(Symbols.change(Keypads.BACK_C2,
                    backC2.getImage()));
        } else if (disneyQ1.isHover()) {
            disneyQ1.setImage(Symbols.change(Keypads.DISNEY_Q1,
                    disneyQ1.getImage()));
        } else if (hollowStar1.isHover()) {
            hollowStar1.setImage(Symbols.change(Keypads.HOLLOW_STAR1,
                    hollowStar1.getImage()));
        } else if (curvyH2.isHover()) {
            curvyH2.setImage(Symbols.change(Keypads.CURVY_H2,
                    curvyH2.getImage()));
        } else if (spanish1.isHover()) {
            spanish1.setImage(Symbols.change(Keypads.SPANISH_QUESTION1,
                    spanish1.getImage()));
        } else if (copyright.isHover()) {
            copyright.setImage(Symbols.change(Keypads.COPYRIGHT,
                    copyright.getImage()));
        } else if (leSac.isHover()) {
            leSac.setImage(Symbols.change(Keypads.THE_SAC,
                    leSac.getImage()));
        } else if (disneyQ2.isHover()) {
            disneyQ2.setImage(Symbols.change(Keypads.DISNEY_Q2,
                    disneyQ2.getImage()));
        } else if (russianX1.isHover()) {
            russianX1.setImage(Symbols.change(Keypads.RUSSIAN_X1,
                    russianX1.getImage()));
        } else if (not3.isHover()) {
            not3.setImage(Symbols.change(Keypads.NOT_THREE,
                    not3.getImage()));
        } else if (lambda2.isHover()) {
            lambda2.setImage(Symbols.change(Keypads.STROKED_LAMBDA2,
                    lambda2.getImage()));
        } else if (hollowStar2.isHover()) {
            hollowStar2.setImage(Symbols.change(Keypads.HOLLOW_STAR2,
                    hollowStar2.getImage()));
        } else if (russianSix1.isHover()) {
            russianSix1.setImage(Symbols.change(Keypads.RUSSIAN_SIX1,
                    russianSix1.getImage()));
        } else if (paragraph1.isHover()) {
            paragraph1.setImage(Symbols.change(Keypads.PARAGRAPH1,
                    paragraph1.getImage()));
        } else if (tB1.isHover()) {
            tB1.setImage(Symbols.change(Keypads.TB_1,
                    tB1.getImage()));
        } else if (russianCat2.isHover()) {
            russianCat2.setImage(Symbols.change(Keypads.RUSSIAN_CAT2,
                    russianCat2.getImage()));
        } else if (russianX2.isHover()) {
            russianX2.setImage(Symbols.change(Keypads.RUSSIAN_X2,
                    russianX2.getImage()));
        } else if (spanish2.isHover()) {
            spanish2.setImage(Symbols.change(Keypads.SPANISH_QUESTION2,
                    spanish2.getImage()));
        } else if (smile1.isHover()) {
            smile1.setImage(Symbols.change(Keypads.SMILEY1,
                    smile1.getImage()));
        } else if (psi1.isHover()) {
            psi1.setImage(Symbols.change(Keypads.PSI1,
                    psi1.getImage()));
        } else if (smile2.isHover()) {
            smile2.setImage(Symbols.change(Keypads.SMILEY2,
                    smile2.getImage()));
        } else if (tB2.isHover()) {
            tB2.setImage(Symbols.change(Keypads.TB_2,
                    tB2.getImage()));
        } else if (cDot.isHover()) {
            cDot.setImage(Symbols.change(Keypads.C_DOT,
                    cDot.getImage()));
        } else if (paragraph2.isHover()) {
            paragraph2.setImage(Symbols.change(Keypads.PARAGRAPH2,
                    paragraph2.getImage()));
        } else if (shrek3.isHover()) {
            shrek3.setImage(Symbols.change(Keypads.ALIEN_THREE,
                    shrek3.getImage()));
        } else if (star.isHover()) {
            star.setImage(Symbols.change(Keypads.STAR,
                    star.getImage()));
        } else if (russianSix2.isHover()) {
            russianSix2.setImage(Symbols.change(Keypads.RUSSIAN_SIX2,
                    russianSix2.getImage()));
        } else if (backEuro2.isHover()) {
            backEuro2.setImage(Symbols.change(Keypads.REVERSE_EURO2,
                    backEuro2.getImage()));
        } else if (puzzle.isHover()) {
            puzzle.setImage(Symbols.change(Keypads.PUZZLE,
                    puzzle.getImage()));
        } else if (aeyyLmao.isHover()) {
            aeyyLmao.setImage(Symbols.change(Keypads.AE,
                    aeyyLmao.getImage()));
        } else if (psi2.isHover()) {
            psi2.setImage(Symbols.change(Keypads.PSI2,
                    psi2.getImage()));
        } else if (russianHN.isHover()) {
            russianHN.setImage(Symbols.change(Keypads.RUSSIAN_NH,
                    russianHN.getImage()));
        } else if (ohms.isHover()) {
            ohms.setImage(Symbols.change(Keypads.OMEGA,
                    ohms.getImage()));
        }

    }

    //Simon Says methods
    @FXML
    private void redPress(){
        write(SimonSays.RED);
    }

    @FXML
    private void bluePress(){
        write(SimonSays.BLUE);
    }

    @FXML
    private void yellowPress(){
        write(SimonSays.YELLOW);
    }

    @FXML
    private void greenPress(){
        write(SimonSays.GREEN);
    }

    private void write(SimonSays color){
        simonColors.append(Simon.next(color, strikes.getValue()));
        simonResults.setText(simonColors.toString());
    }

    @FXML
    private void sliderMoved(){
        simonColors = new StringBuilder(Simon.newOrder(simonColors.toString(), strikes.getValue()));
        simonResults.setText(simonColors.toString());
    }

    @FXML
    private void clearOrder(){
        simonColors = new StringBuilder();
        simonResults.setText("");
    }

    //Who's on First methods
    @FXML
    private void findPanel(){
        Image sample = OnFirst.findPanel(step1In.getText());
        if (sample != null) {
            currentPanel.setImage(sample);
        } else {
            currentPanel.imageProperty().set(null);
        }
    }

    @FXML
    private void logWord(){
        if (!step2In.getText().isEmpty()) {
            String[] list = OnFirst.retList(step2In.getText());
            if (list != null){
                whosCurrentList = list;
                step2Out.setDisable(false);
                if (whosCurrentList.length != 1) {
                    whosButtonTabForward.setDisable(false);
                    step2Iterator = 0;
                    step2Out.setText(whosCurrentList[step2Iterator]);
                } else {
                    step2Out.setText(whosCurrentList[0]);
                    whosButtonTabForward.setDisable(true);
                }
                whosButtonTabBack.setDisable(true);

            } else {
                whosButtonTabBack.setDisable(true);
                whosButtonTabForward.setDisable(true);
                step2Out.setDisable(true);
                step2Out.setText("");
            }
        }

    }

    @FXML
    private void tabThrough(){
        if (whosButtonTabBack.isHover()){
            step2Iterator--;
            if (step2Iterator == 0){
                whosButtonTabBack.setDisable(true);
            }
            whosButtonTabForward.setDisable(false);

        } else {
            step2Iterator++;
            if (step2Iterator == whosCurrentList.length - 1){
                whosButtonTabForward.setDisable(true);
            }
            whosButtonTabBack.setDisable(false);
        }
        step2Out.setText(whosCurrentList[step2Iterator]);
    }

    @FXML
    private void clearStreams(){
        step1In.setText("");
        step2In.setText("");
        step2Out.setText("");
        step2Out.disableProperty().set(true);
        whosButtonTabBack.setDisable(true);
        whosButtonTabForward.setDisable(true);
    }

    //Memory methods
    @FXML
    private void displaySet(){

    }

    @FXML
    private void labelSet(){

    }

    @FXML
    private void positionSet(){

    }

    @FXML
    private void clearMem(){
        memStage = 0;
        Memory.clear();
    }

    //Morse methods
    @FXML
    private void typeTrigger() {
        String input = morseInput.getText().replaceAll("([a-z])", "")
                .replaceAll("([A-Z])", "").replaceAll("([0-9])", "");

        input = enhancedReplace(input);

        if (!input.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (String words : Morse.translate(input)) {
                builder.append(words).append("\n");
            }
            morseOutput.setText(builder.toString());
        }
    }

    private String enhancedReplace(String input){
        for (int i = 33; i < 45; i++){
            String a = String.valueOf((char)i);
            input = input.replace(a, "");
        }
        input = input.replace("/", "");
        input = input.replace("{", "");
        input = input.replace("|", "");
        input = input.replace("}", "");
        input = input.replace("~", "");

        for (int i = 58; i < 65; i++){
            String a = String.valueOf((char)i);
            input = input.replace(a, "");
        }

        for (int i = 91; i < 97; i++){
            String a = String.valueOf((char)i);
            input = input.replace(a, "");
        }

        return input;
    }

    //Complex method
    @FXML
    private void solveCombos(){
        complexOutput.setText(Complex.solve(complexInput.getText()));
    }

    @FXML
    private void quickClear(){
        complexInput.setText("");
    }

    //Sequence methods
    @FXML
    private void nextOcc(){
        if (seqNextRed.isHover()){
            seqRed.setImage(Sequences.nextOccurrence(SequencedWires.RED));
            checkValue(SequencedWires.RED);
        } else if (seqNextBlue.isHover()){
            seqBlue.setImage(Sequences.nextOccurrence(SequencedWires.BLUE));
            checkValue(SequencedWires.BLUE);
        } else if (seqNextBlack.isHover()){
            seqBlack.setImage(Sequences.nextOccurrence(SequencedWires.BLACK));
            checkValue(SequencedWires.BLACK);
        }
    }

    @FXML
    private void prevOcc(){
        if (seqPrevRed.isHover()){
            seqRed.setImage(Sequences.prevOccurrence(SequencedWires.RED));
            checkValue(SequencedWires.RED);
        } else if (seqPrevBlue.isHover()){
            seqBlue.setImage(Sequences.prevOccurrence(SequencedWires.BLUE));
            checkValue(SequencedWires.BLUE);
        } else if (seqPrevBlack.isHover()){
            seqBlack.setImage(Sequences.prevOccurrence(SequencedWires.BLACK));
            checkValue(SequencedWires.BLACK);
        }
    }

    @FXML
    private void resetSequence(){
        seqNextBlack.setDisable(false);
        seqNextBlue.setDisable(false);
        seqNextRed.setDisable(false);
        seqPrevBlack.setDisable(true);
        seqPrevBlue.setDisable(true);
        seqPrevRed.setDisable(true);

        for (SequencedWires wire : SequencedWires.values()){
            wire.setIndex(1);
        }
        seqRed.setImage(Sequences.prevOccurrence(SequencedWires.RED));
        seqBlue.setImage(Sequences.prevOccurrence(SequencedWires.BLUE));
        seqBlack.setImage(Sequences.prevOccurrence(SequencedWires.BLACK));
        seqLabelRed.setText(labelSet(SequencedWires.RED));
        seqLabelBlue.setText(labelSet(SequencedWires.BLUE));
        seqLabelBlack.setText(labelSet(SequencedWires.BLACK));
    }

    private void checkValue(SequencedWires currentWire){
        switch (currentWire){
            case BLUE:
                disableSet(currentWire, seqPrevBlue, seqNextBlue);
                seqLabelBlue.setText(labelSet(currentWire));
                break;
            case RED:
                disableSet(currentWire, seqPrevRed, seqNextRed);
                seqLabelRed.setText(labelSet(currentWire));
                break;
            default:
                disableSet(currentWire, seqPrevBlack, seqNextBlack);
                seqLabelBlack.setText(labelSet(currentWire));
                break;
        }
    }

    private void disableSet(SequencedWires currentWire, Button seqPrev, Button seqNext) {
        if (currentWire.getIdx() == 0){
            seqPrev.setDisable(true);
        } else if (currentWire.getIdx() == 8){
            seqNext.setDisable(true);
        } else  if (currentWire.getIdx() == 1 || currentWire.getIdx() == 7){
            seqPrev.setDisable(false);
            seqNext.setDisable(false);
        }
    }

    private String labelSet(SequencedWires currentWire){
        switch (currentWire.getIdx()){
            case 0:
                return  "1st";
            case 1:
                return "2nd";
            case 2:
                return "3rd";
            case 3:
                return "4th";
            case 4:
                return "5th";
            case 5:
                return "6th";
            case 6:
                return "7th";
            case 7:
                return "8th";
            case 8:
                return "9th";
            default:
                return "10th";
        }
    }

    //Maze methods
    @FXML
    private void findMaze(){
        try {
            if (mazeCoords.getText().length() == 2) {
                if (mazeTop.isSelected()) {
                    currentMaze.setImage(Mazes.findMaze(mazeCoords.getText(), 0));
                } else if (mazeBottom.isSelected()) {
                    currentMaze.setImage(Mazes.findMaze(mazeCoords.getText(), 1));
                } else {
                    currentMaze.setImage(Mazes.findMaze(letNumNotation(mazeCoords.getText()), 2));
                }
            }
        } catch (IllegalArgumentException illegal){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Check that notation");
            alert.setContentText("Somethin' ain't right");
            alert.show();
        }
        mazeCoords.setText("");
    }

    private String letNumNotation(String notation){
        StringBuilder out = new StringBuilder();
        switch (notation.toUpperCase().charAt(0)){
            case 'A':
                out.append("10");
                break;
            case 'B':
                out.append("11");
                break;
            case 'C':
                out.append("12");
                break;
            case 'D':
                out.append("13");
                break;
            case 'E':
                out.append("14");
                break;
            case 'F':
                out.append("15");
                break;
        }
        out.append(notation.charAt(notation.length() - 1));
        return out.toString();
    }

    @FXML
    private void formatCoords(){
        if (mazeTarget.getText().length() == 2){
            if (numberCheck(mazeTarget.getText())){
                mazeTarget.setText("(" + mazeTarget.getText().charAt(0) + ","
                        + mazeTarget.getText().charAt(1) + ")");
            } else {
                mazeTarget.setText("");
            }
        } else if (mazeWhiteDot.getText().length() == 2){
            if (numberCheck(mazeWhiteDot.getText())){
                mazeWhiteDot.setText("(" + mazeWhiteDot.getText().charAt(0) + ","
                        + mazeWhiteDot.getText().charAt(1) + ")");
            } else {
                mazeWhiteDot.setText("");
            }
        }
    }

    private boolean numberCheck(String number){
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException notNumber){
            return false;
        }
        return true;
    }

    @FXML
    private void clearCoords(){
        if (mazeTarget.isHover()){
            mazeTarget.setText("");
        } else if (mazeWhiteDot.isHover()){
            mazeWhiteDot.setText("");
        }
    }

    //Password methods
    @FXML
    private void passwordSolve(){
        passwordResults.setText(Passwords.solve(password1st.getText(),
                password2nd.getText(), password3rd.getText(),
                password4th.getText(), password5th.getText()));
    }

    @FXML
    private void clearFields(){
        password1st.setText("");
        password2nd.setText("");
        password3rd.setText("");
        password4th.setText("");
        password5th.setText("");
    }
}
