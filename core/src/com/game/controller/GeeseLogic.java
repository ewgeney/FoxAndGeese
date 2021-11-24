package com.game.controller;

import static com.game.Main.gameStarted;
import static com.game.view.GameScreen.UserStep;
import static com.game.view.GameScreen.field;
import static com.game.view.GameScreen.geese;
import static java.lang.Thread.sleep;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.game.Main;

import java.util.HashSet;
import java.util.Iterator;

public class GeeseLogic extends GameLogic{
    Main game;

    public GeeseLogic(Polygon bounds, Sprite object, int index, Main game) {
        super(bounds, object, index);
        this.game=game;
    }

    @Override
    protected void setPosition(Polygon chip, int position) {
        super.setPosition(chip, position);
    }

    public void handler() {
        if(gameStarted & newGame){
            createStartPosition();
            newGame = false;
        }
        if(!UserStep){
            if(geese.size()>3){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int[] bestMove = bestMove();
                getIndexOnField(bestMove[0]);
                setPosition(geese.get(bestMove[0]).bounds, bestMove[1]);
                field.board.set(indexOnField, empPos);
                field.board.set(bestMove[1], bestMove[0]);
                UserStep=true;
            }
            else {
                game.flag=1; //Geese loose messages
                game.setScreen(game.getMenuScreen());
                gameStarted=false;
                newGame=true;
            }
        }
    }

    //метод поиска хода
    private int[] bestMove(){

        class Move{
            int indexGeese;
            int indexBestMove;
            int costBestMove=0;
        }
        HashSet<Move> bestMoves=new HashSet<>();
        int costPosition=0;
        //int indexOnField=0;

        //Подсчет стоимости ячеек занятых гусями в текущей позиции
        for (int i = 0; i < field.board.size(); i++) {
            if (field.board.get(i)>=0){
                costPosition+=field.boardCost.get(i);
            }
        }
        //Вычисление лучшего хода из возможных для каждого гуся
        for (int i = 0; i < 13; i++) {
            if (geese.get(i)!=null){
                possibleMove(i);
                Move best = new Move();
                //Подсчет стоимости всех возможных ходов и добавление лучшего в список
                for (int s = 0; s<geese.get(i).arrayMoves.size(); s++){
                    int newCost = costPosition - field.boardCost.get(indexOnField) + field.boardCost.get(geese.get(i).arrayMoves.get(s));
                    if (best.costBestMove<newCost){
                        best.indexGeese = i;
                        best.indexBestMove = geese.get(i).arrayMoves.get(s);
                        best.costBestMove = newCost;
                    }
                }
                if (best.costBestMove-costPosition > 0){
                    bestMoves.add(best);
                }
            }
        }
        Iterator<Move> iterator = bestMoves.iterator();
        Move best = new Move();
        while (iterator.hasNext()){
            Move move = iterator.next();
            if (best.costBestMove<move.costBestMove){
                best=move;
            }
        }
        return new int[]{best.indexGeese, best.indexBestMove};
    }

    //Метод определения возможности хода
    private void possibleMove (int index){
        getIndexOnField(index);
        float [] curPos = {geese.get(index).bounds.getX()+chipWidth/2, geese.get(index).bounds.getY()+chipHeight/2};
        float[][] allVertices = field.getAllVertices();
        geese.get(index).arrayMoves.clear();

        for(int i = 0; i < allVertices.length; i++) {
            //шаг вверх
            if (curPos[0] == allVertices[i][0] & curPos[1] + field.getStep() == allVertices[i][1]) {
                if(field.board.get(i) == -1){
                    //ход возможен
                    geese.get(index).arrayMoves.add(i);
                }
            }
            //шаг вправо
            if (curPos[0] + field.getStep() == allVertices[i][0] & curPos[1] == allVertices[i][1]) {
                if(field.board.get(i) == -1){
                    //ход возможен
                    geese.get(index).arrayMoves.add(i);
                }
            }
            //шаг влево
            if (curPos[0] - field.getStep() == allVertices[i][0] & curPos[1] == allVertices[i][1]) {
                if(field.board.get(i) == -1){
                    //ход возможен
                    geese.get(index).arrayMoves.add(i);
                }
            }
            //шаг вниз
            if (curPos[0] == allVertices[i][0] & curPos[1] - field.getStep() == allVertices[i][1]) {
                if(field.board.get(i) == -1){
                    //ход возможен
                    geese.get(index).arrayMoves.add(i);
                }
            }
        }
        if (geese.get(index).arrayMoves.size()>1){
            int d=0;
            for (int move: geese.get(index).arrayMoves){
                if (move!=0 && move!=3 && move!=6 && move!=12 && move!=20 && move!=26 && move!=30 && move!=32){
                    if (d==0){
                        d++;
                        continue;
                    }
                    field.boardCost.put(move, field.boardCost.get(move)+50);
                }
            }
        }
    }

    //Расстановка гусей в стартовую позицию
    private void createStartPosition() {
        switch (index) {
            case 0:
                setPosition(bounds, field.A5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.A5, index);
                break;
            case 1:
                setPosition(bounds, field.B5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.B5, index);
                break;
            case 2:
                setPosition(bounds, field.C5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.C5, index);
                break;
            case 3:
                setPosition(bounds, field.D5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.D5, index);
                break;
            case 4:
                setPosition(bounds, field.E5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.E5, index);
                break;
            case 5:
                setPosition(bounds, field.F5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.F5, index);
                break;
            case 6:
                setPosition(bounds, field.G5);
                field.board.set(indexOnField, empPos);
                field.board.set(field.G5, index);
                break;
            case 7:
                setPosition(bounds, field.C6);
                field.board.set(indexOnField, empPos);
                field.board.set(field.C6, index);
                break;
            case 8:
                setPosition(bounds, field.C7);
                field.board.set(indexOnField, empPos);
                field.board.set(field.C7, index);
                break;
            case 9:
                setPosition(bounds, field.D6);
                field.board.set(indexOnField, empPos);
                field.board.set(field.D6, index);
                break;
            case 10:
                setPosition(bounds, field.D7);
                field.board.set(indexOnField, empPos);
                field.board.set(field.D7, index);
                break;
            case 11:
                setPosition(bounds, field.E6);
                field.board.set(indexOnField, empPos);
                field.board.set(field.E6, index);
                break;
            case 12:
                setPosition(bounds, field.E7);
                field.board.set(indexOnField, empPos);
                field.board.set(field.E7, index);
                break;
        }
    }
}
