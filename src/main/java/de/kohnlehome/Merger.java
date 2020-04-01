package de.kohnlehome;

public class Merger implements IMerger {
    @Override
    public int[] merge(int[] leftSide, int[] rightSide) {
        int[] neueListe = new int[leftSide.length + rightSide.length];
        int indexLinkeListe = 0, indexRechteListe = 0, indexNeueListe = 0;

        while (indexLinkeListe < leftSide.length && indexRechteListe < rightSide.length) {
            if (leftSide[indexLinkeListe] <= rightSide[indexRechteListe]) {
                neueListe[indexNeueListe] = leftSide[indexLinkeListe];
                indexLinkeListe += 1;

            } else {
                neueListe[indexNeueListe] = rightSide[indexRechteListe];
                indexRechteListe += 1;
            }
            indexNeueListe += 1;
        }

        while (indexLinkeListe < leftSide.length) {
            neueListe[indexNeueListe] = leftSide[indexLinkeListe];
            indexLinkeListe += 1;
            indexNeueListe += 1;
        }
        while (indexRechteListe < rightSide.length) {
            neueListe[indexNeueListe] = rightSide[indexRechteListe];
            indexRechteListe += 1;
            indexNeueListe += 1;
        }
        return neueListe;


    }
}
