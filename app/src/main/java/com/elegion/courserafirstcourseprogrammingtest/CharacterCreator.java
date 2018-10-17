package com.elegion.courserafirstcourseprogrammingtest;

import android.widget.Toast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import android.widget.Toast;


public class CharacterCreator extends Observable  implements Serializable{

    public enum Specialization {
        WARRIOR, ARCHER, MAGE
    }

    public enum Race {
        HUMAN, ELF, ORC, DWARF
    }

    public enum Attribute {
        STRENGTH, AGILITY, INTELLECT, STAMINA, LUCK
    }

    public enum Perk {
        BERSERK, CALM, LIGHTWEIGHT, HEAVYARMORED, OBSERVANT, MEDITATIONS
    }

    private String mName;
    private Specialization mSpecialization;
    private Race mRace;
    private int mAvailablePoints;

    private Map<String, Integer> mAttributesMap = new HashMap<>();
    private Map<String, Boolean> mPerksMap = new HashMap<>();


    public CharacterCreator() {
        mRace = Race.HUMAN;
        mSpecialization = Specialization.WARRIOR;
        mAvailablePoints = 5;
        mAttributesMap.put(Attribute.STRENGTH.name(), 5);
        mAttributesMap.put(Attribute.AGILITY.name(), 5);
        mAttributesMap.put(Attribute.INTELLECT.name(), 5);
        mAttributesMap.put(Attribute.STAMINA.name(), 5);
        mAttributesMap.put(Attribute.LUCK.name(), 5);
    }


    public String[] getSpecializations() {
        // TODO: 11.12.2017
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Specialization
        *   Строки должны начинаться с заглавной буквы, остальные строчные
        * */

        Specialization[] spec = Specialization.values();
        String[] specializations = new String[spec.length];

        for (int i = 0; i < spec.length; i++) {
            specializations[i] = firstUpperCase(spec[i].name());
        }

        return specializations;
    }

    public void setSpecialization(int position) {
        // TODO: 11.12.2017
        /*
        *  этот метод задает специализацию в переменную mSpecialization
        *  на вход подается число, и из enum Specialization выбирается соответствующий класс
        *  0 - Warrior
        *  1 - Archer
        *  2 - Mage
        *  если введенное число меньше 0, то в mSpecialization записывается самое первое (порядковый номер - 0) значение
        *  если введенное число больше длины enum, то в mSpecialization записывается самое последнее (длина - 1) значение
        *
        * */
        Specialization[] spec = Specialization.values();

        if (position < 0) {
            mSpecialization = spec[0];
        }

        if (position > spec.length) {
            mSpecialization = spec[spec.length - 1];
        }

        switch (position) {
            case 0:
                mSpecialization = spec[0];
                break;
            case 1:
                mSpecialization = spec[1];
                break;
            case 2:
                mSpecialization = spec[2];
                break;
        }

    }

    public String[] getRaces() {
        // TODO: 11.12.2017
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Races
        *    Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        * */

        Race[] race = Race.values();
        String[] races = new String[race.length];

        for (int i = 0; i < race.length; i++) {
            races[i] = firstUpperCase(race[i].name());
        }

        return races;
    }

    public void setRace(int position) {
        // TODO: 11.12.2017
        /*
        *  этот метод задает специализацию в переменную mRace
        *  на вход подается число, и из enum Race выбирается соответствующая раса
        *  0 - Human
        *  1 - Elf
        *  2 - Orc
        *  3 - Dwarf
        *  если введенное число меньше 0, то в mRace записывается самое первое (порядковый номер - 0) значение
        *  если введенное число больше длины enum, то в mRace записывается самое последнее (длина - 1) значение
        *
        * */

        Race[] race = Race.values();

        if (position < 0) {
            mRace = race[0];
        }

        if (position > race.length) {
            mRace = race[race.length - 1];
        }

        switch (position) {
            case 0:
                mRace = race[0];
                break;
            case 1:
                mRace = race[1];
                break;
            case 2:
                mRace = race[2];
                break;
            case 3:
                mRace = race[3];
                break;
        }
    }

    public String[] getAttributes() {

        // TODO: 11.12.2017
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Attribute
        *    Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        * */

        Attribute[] atr = Attribute.values();
        String[] atrs = new String[atr.length];

        for (int i = 0; i < atr.length; i++) {
            atrs[i] = firstUpperCase(atr[i].name());
        }

        return atrs;
    }

    public String[] getPerks() {
        // TODO: 11.12.2017
        /*
        *   этот метод должен возвращать массив строк, созданных на основе enum Perk
        *   Строка должна быть формата - первая буква заглавная, остальные строчные
        *   One, Two, Three
        *
        * */

        Perk[] perk = Perk.values();
        String[] perks = new String[perk.length];

        for (int i = 0; i < perk.length; i++) {
            perks[i] = firstUpperCase(perk[i].name());
        }

        return perks;
    }
    public void updateAttributeValue(int position, int updateTo) {
        // TODO: 11.12.2017
        /*
        *  этот метод увеличивает/уменьшает соответствующее значение атрибута
        *  рекомендуется реализовывать его в последнюю очередь
        *
        * 1. на вход подается позиция изменяемого атрибута и на сколько нужно этот атрибут увеличить/уменьшить
        * 2. по позиции атрибута выявляется название атрибута из enum Attribute
        * 3. по названию атрибута получается значение атрибута из mAttributesMap
        * 4. если атрибут собирается увеличиться и у персонажа достаточно очков для увеличения атрибута (mAvailablePoints)
        *    или
        *    если атрибут собирается уменьшиться и уменьшенный атрибут будет больше 0,
        *    то атрибут изменяется, количество доступных очков меняется в противоположную сторону.
        *
        * 5. убедитесь в том, что измененное значение атрибута записано в mAttributesMap
        * 6. убедитесь в том, что измененное значение количества очков записано в mAvailablePoints;
        * 7. после изменения нужно вызвать методы setChanged(); notifyObservers();
        *    для того, чтобы изменения отразились на верстке
        *
        * пример работы алгоритма.
        * на вход подается (0, -1)
        * из значения 0 выясняем, что меняться будет атрибут STRENGTH
        * получаем текущее значение этого атрибута из mAttributesMap
        * допустим, оно равно 3
        * по условию все алгоритма все проходит
        * сила уменьшается до 2, количество доступных очков увеличивается на +1
        *
        * если STRENGTH равно 1, то ничего не происходит,
        * так как мы не можем уменьшить атрибут ниже 1
        *
        * если на вход пришло (0, 1)
        *   если доступных очков больше 0,
        *       то STRENGTH увеличивается на 1, количество доступных очков уменьшается на 1
        *   если количество доступных очков равно 0
        *       то мы не можем увеличить атрибут, ничего не происходит        *
        * */

        //получаем название атрибута по позиции
        Attribute atrName = Attribute.values()[position];

        //по названию атрибута получаем значение атрибута из mAttributesMap String, Integer
        Integer atrValue = mAttributesMap.get(atrName.toString());

        //проверка количества доступных очков и изменение атрибута

        atrValue = atrValue + updateTo;

        if (mAvailablePoints < 1 && updateTo > 0) {
            atrValue -= updateTo;
        } else if (atrValue < 1) {
            atrValue -= updateTo;
        } else {
            if (atrValue < mAttributesMap.get(atrName.toString())) {
                mAvailablePoints += 1;
            }

            if (atrValue > mAttributesMap.get(atrName.toString())) {
                mAvailablePoints -= 1;
            }
        }


        mAttributesMap.put(atrName.toString(), atrValue);

        setChanged();
        notifyObservers();
    }

    /*
    word.substring(0, 1) — возвращает первую букву в слове
    word.substring(0, 1).toUpperCase() — переводит первую букву в верхний регистр
    word.substring(1) — добавляет остальные символы без изменения
    */

    public String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return ""; //или return word;
        word = word.toLowerCase();
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvailablePoints() {
        return String.valueOf(mAvailablePoints);
    }

    public Map<String, Integer> getAttributesMap() {
        return mAttributesMap;
    }

    public void checkPerk(String text, boolean isChecked) {
        mPerksMap.put(text, isChecked);
    }

    public Character create() {
        Character character = new Character();
        character.setName(mName);
        character.setRace(mRace);
        character.setSpecialization(mSpecialization);
        character.setAttributes(mAttributesMap);
        character.setPerks(mPerksMap);
        character.calculateParameters();
        return character;
    }

    public Specialization getSpecialization() {
        return mSpecialization;
    }

    public Race getRace() {
        return mRace;
    }

    public Map<String, Boolean> getPerksMap() {
        return mPerksMap;
    }

    public void setAvailablePoints(int availablePoints) {
        mAvailablePoints = availablePoints;
    }

    public int getRacePosition() {
        return mRace.ordinal();
    }

    public int getSpecializationPosition() {
        return mSpecialization.ordinal();
    }
}
