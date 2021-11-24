package com.game.controller;

import static com.game.Main.gameStarted;
import static com.game.view.GameScreen.UserStep;
import static com.game.view.GameScreen.field;
import static com.game.view.GameScreen.fox;
import static com.game.view.GameScreen.geese;
import static java.lang.Math.abs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.game.Main;
import com.game.view.GameScreen;

import java.util.ArrayList;

public class FoxLogic extends GameLogic{
    float[][] allVertices = field.getAllVertices();
    Main game;

    public FoxLogic(Polygon bounds, Sprite object, int index, Main game) {
        super(bounds, object, index);
        this.game = game;
    }

    @Override
    protected void setPosition(Polygon chip, int position){
        super.setPosition(chip, position);
        field.board.set(indexOnField, empPos);
        field.board.set(position, index);
        setFieldCost(position, 0);
    }

    public void handler(){
        Gdx.input.setInputProcessor(new FoxInputListener());

        if (gameStarted & newGame){
            setPosition(bounds, field.D3);
            newGame = false;
            game.flag=0;
        }
    }
    public class FoxInputListener extends InputAdapter {

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            //определяем нажатие на фишку, если попал двигаем в новую позицию
            if ((screenX > bounds.getX() - chipWidth) & (screenX < bounds.getX() + chipWidth) &
                    ((Gdx.graphics.getHeight() - screenY) < bounds.getY() + chipHeight) &
                    ((Gdx.graphics.getHeight() - screenY) > bounds.getY() - chipHeight)) {
                bounds.setPosition(screenX-chipWidth/2, Gdx.graphics.getHeight() - screenY-chipHeight/2);
                return true;
            }
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            //текущая позиция центра фишки -- возможно стоит использовать screenX
            float [] curPos = {bounds.getX()+chipWidth/2, bounds.getY()+chipHeight/2};
            getIndexOnField(index);

            //вычисление в какую ячейку встает лиса
            for(int i = 0; i < allVertices.length; i++){

                if(curPos[0] < allVertices[i][0]+field.getStep()/2 & curPos[0] > allVertices[i][0]-field.getStep()/2
                 & curPos[1] < allVertices[i][1]+field.getStep()/2 & curPos[1] > allVertices[i][1]-field.getStep()/2){

                    //Проверка не занята ли позиция куда хочет встать лиса
                    if (field.board.get(i)!=empPos){
                        break;
                    }
                    //Проверка что ходит игрок
                    if (!UserStep){
                        break;
                    }

                    //Проверка что есть доступные ходы
                    if (!possibleMove()){
                        game.flag=2; //Fox loose messages
                        game.setScreen(game.getMenuScreen());
                        gameStarted=false;
                        newGame=true;
                        break;
                        /*for (int move:fox.arrayMoves){
                            if (i==move){
                                setPosition(bounds, i);
                                UserStep=false;
                                return true;
                            }
                        }*/
                    }

                    //проверка что позиция на 1 шаге от текущей
                    if(allVertices[i][0] == allVertices[indexOnField][0] & abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()
                    || allVertices[i][1] == allVertices[indexOnField][1] & abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()){

                        setPosition(bounds, i);
                        UserStep=false;
                        return true;
                    }
                    //проверка хода по диагонали на 1 шаг, т.к. по диагонали можно ходить только из вершин с нулевым или четным индексом
                    //проверяем что положение лисы валидно для хода по диагонали
                    if (abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep() & abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()
                    & indexOnField %2==0){

                        setPosition(bounds, i);
                        UserStep=false;
                        return true;
                    }
                    //бой вниз
                    if(allVertices[i][0] == allVertices[indexOnField][0] && abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][1] + field.getStep())==allVertices[j][1]) && (allVertices[i][0]==allVertices[j][0])){
                                    if(field.board.get(j)>=0){

                                        setPosition(bounds, i);
                                        GameScreen.geese.remove(field.board.get(j));
                                        field.board.set(j, empPos);
                                        UserStep=false;
                                        return true;
                                    }
                            }
                        }
                    }
                    //бой вверх
                    if(allVertices[i][0] == allVertices[indexOnField][0] && abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][1] - field.getStep())==allVertices[j][1]) && (allVertices[i][0]==allVertices[j][0])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой влево
                    if(allVertices[i][1] == allVertices[indexOnField][1] && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] + field.getStep())==allVertices[j][0]) && (allVertices[i][1]==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой вправо
                    if(allVertices[i][1] == allVertices[indexOnField][1] && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] - field.getStep())==allVertices[j][0]) && (allVertices[i][1]==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой по диагонали вправо-вверх
                    if(abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2 && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] + field.getStep())==allVertices[j][0]) && ((allVertices[i][1] + field.getStep())==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой по диагонали влево-вниз
                    if(abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2 && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] - field.getStep())==allVertices[j][0]) && ((allVertices[i][1] - field.getStep())==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой по диагонали влево-вверх
                    if(abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2 && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] - field.getStep())==allVertices[j][0]) && ((allVertices[i][1] + field.getStep())==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                    //бой по диагонали вправо-вниз
                    if(abs(allVertices[i][1]-allVertices[indexOnField][1])==field.getStep()*2 && abs(allVertices[i][0]-allVertices[indexOnField][0])==field.getStep()*2){
                        for(int j = 0; j < allVertices.length; j++){
                            if(((allVertices[i][0] + field.getStep())==allVertices[j][0]) && ((allVertices[i][1] - field.getStep())==allVertices[j][1])){
                                if(field.board.get(j)>=0){
                                    setPosition(bounds, i);
                                    GameScreen.geese.remove(field.board.get(j));
                                    field.board.set(j, empPos);
                                    UserStep=false;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            //если перемещение лисы не валидное возвращаем в исходное положение
            setPosition(bounds, indexOnField);
            return true;
        }
    }

    //Рекурсивная функция подсчета стоимости ячеек в зависимости от положения лисы на поле
    //Раздает оценки ячеек в зависимости от удаленности от лисы 1шаг - 500 очков, 2шага - 400 и т.д.
    //На входе принимает индекс ячейки в которой находится лиса, depth должно быть == 0;
    private void setFieldCost(int i, int depth) {
        if (depth==0){
            field.boardCost.clear();
        }
        depth++;
        final int x = 0;
        final int y = 1;
        float step = field.getStep();
        ArrayList<Integer> indexStep = new ArrayList<>();
        int cost = 600-100*depth;
        field.boardCost.put(i, 0);
        float[] curPos = new float[]{field.getAllVertices()[i][0], field.getAllVertices()[i][1]};

        curPos[y]-=step*depth;
        for (int f = 0; f < field.getAllVertices().length; f++) {
            if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                indexStep.add(f);
            }
        }
        for (int d = 0; d < depth; d++) {
            curPos[x] += step;
            for (int f = 0; f < field.getAllVertices().length; f++) {
                if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                    indexStep.add(f);
                }
            }
        }
        for (int d = 0; d < depth; d++) {
            for (int s = 0; s < 2; s++) {
                curPos[y] += step;
                for (int f = 0; f < field.getAllVertices().length; f++) {
                    if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                        indexStep.add(f);
                    }
                }
            }
        }
        for (int d = 0; d < depth; d++) {
            for (int s = 0; s < 2; s++) {
                curPos[x] -= step;
                for (int f = 0; f < field.getAllVertices().length; f++) {
                    if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                        indexStep.add(f);
                    }
                }
            }
        }
        for (int d = 0; d < depth; d++) {
            for (int s = 0; s < 2; s++) {
                curPos[y] -= step;
                for (int f = 0; f < field.getAllVertices().length; f++) {
                    if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                        indexStep.add(f);
                    }
                }
            }
        }
        for (int d = 0; d < depth; d++) {
            curPos[x] += step;
            for (int f = 0; f < field.getAllVertices().length; f++) {
                if (curPos[y] == field.getAllVertices()[f][y] && curPos[x] == field.getAllVertices()[f][x]) {
                    indexStep.add(f);
                }
            }
        }
        for (int b = 0; b < indexStep.size(); b++) {
            field.boardCost.put(indexStep.get(b), cost+b);
        }
        if (depth!=6){
            setFieldCost(i, depth);
        }
    }


    private boolean possibleMove() {
        getIndexOnField(index);
            //ход по диагонали
            for (int i = 0; i < allVertices.length; i++) {
                if (abs(allVertices[i][1] - allVertices[indexOnField][1]) == field.getStep() && abs(allVertices[i][0] - allVertices[indexOnField][0]) == field.getStep()
                        && indexOnField % 2 == 0) {
                    if (field.board.get(i) == -1){
                        //можно ходить
                        fox.arrayMoves.add(i);
                    }
                    else {
                        for (int j = 0; j < allVertices.length; j++) {
                            if (abs(allVertices[j][1] - allVertices[indexOnField][1]) == field.getStep()*2 && abs(allVertices[j][0] - allVertices[indexOnField][0]) == field.getStep()*2){
                                if(field.board.get(j) == -1){
                                    //можно бить
                                    fox.arrayMoves.add(j);
                                }
                            }
                        }
                    }

                }

                //шаг вверх и вниз
                if (allVertices[i][0] == allVertices[indexOnField][0] && abs(allVertices[i][1] - allVertices[indexOnField][1]) == field.getStep()) {
                    if(field.board.get(i) == -1){
                        //можно ходить
                        fox.arrayMoves.add(i);
                    }
                    else {
                        for (int j = 0; j < allVertices.length; j++) {
                            if (allVertices[j][0] == allVertices[indexOnField][0] && abs(allVertices[j][1] - allVertices[indexOnField][1]) == field.getStep()*2){
                                if(field.board.get(j) == -1){
                                    //можно бить
                                    fox.arrayMoves.add(j);
                                }
                            }
                        }
                    }
                }
                //шаг вправо и влево
                if (abs(allVertices[i][0] - allVertices[indexOnField][0]) == field.getStep() && allVertices[i][1] == allVertices[indexOnField][1]) {
                    if(field.board.get(i) == -1){
                        //можно ходить
                        fox.arrayMoves.add(i);
                    }
                    else {
                        for (int j = 0; j < allVertices.length; j++) {
                            if (abs(allVertices[j][0] - allVertices[indexOnField][0]) == field.getStep()*2 && allVertices[j][1] == allVertices[indexOnField][1]){
                                if(field.board.get(j) == -1){
                                    //можно бить
                                    fox.arrayMoves.add(j);
                                }
                            }
                        }
                    }
                }
            }

            if (!fox.arrayMoves.isEmpty()){
                return true;
            }
            else return false;
    }
}
