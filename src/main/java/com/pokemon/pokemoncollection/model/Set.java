package com.pokemon.pokemoncollection.model;

public class Set {
    private String code;
    private int totalCards;
    private String logoUrl;
    private boolean downloaded;

    public String getCode() {
        return code;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public boolean isDownloaded() {
        return downloaded;
    }

    @Override
    public String toString() {
        return "Set{" +
                "code='" + code + '\'' +
                ", totalCards=" + totalCards +
                ", logoUrl='" + logoUrl + '\'' +
                ", downloaded=" + downloaded +
                '}';
    }
}
