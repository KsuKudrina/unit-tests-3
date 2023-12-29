package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("прекрасный")) {
            return "GoodMood";
        }
        if (message.contains("обычный")) {
            return "NormalMood";
        }
        if (message.contains("отвратительный")) {
            return "BadMood";
        }
        return null;

    }
}