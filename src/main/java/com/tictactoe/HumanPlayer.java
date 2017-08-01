package com.tictactoe;

public class HumanPlayer implements Player {
    private String input;
    private UserInput receiver;
    private UserInputValidator validator;
    private String symbol;
    private String opponentSymbol;
    private Rules rules;
    private Messages messages;

    public HumanPlayer(UserInput receiver, UserInputValidator validator, Messages messages) {
       this.receiver = receiver;
       this.validator = validator;
       this.messages = messages;
    }

    public String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    @Override
    public void addRules(Rules rules) {
        this.rules = rules;
    }

    @Override
    public void addOpponentSymbol(String opponentSymbol) {
        this.opponentSymbol = opponentSymbol;
    }

    @Override
    public void addSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public int obtainValidCellSelection() {
        int cell = 0;
        System.out.println(messages.HumanPlayer_obtainValidCellSelection);
        boolean awaitingSelection = true;
        while (awaitingSelection) {
            try {
                String selection = this.getInput();
                cell = Integer.parseInt(selection);
                awaitingSelection = false;
            } catch (NumberFormatException e) {
                System.out.println(messages.HumanPlayer_numberFormatException);
            }
        }
        boolean isValid = validator.validateCellSelection(cell);
        if (!isValid) {
            System.out.println (messages.HumanPlayer_invalidCellNumber);
            cell = this.obtainValidCellSelection();
        }
        return cell;
    }
}
