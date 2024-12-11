package Practical_12;

// Class representing a review for a paper
class Review implements Comparable<Review> {

    private int id;
    private String reviewer;
    private int score; // Number: 1-10
    private int confidence; // Number: 1-5
    private String summary; // Text

    // Constructor for Review
    public Review(int id, String reviewer, int score, int confidence, String summary) {
        this.id = id;
        this.reviewer = reviewer;
        this.score = score;
        this.confidence = confidence;
        this.summary = summary;
    }
    public int getId() {
        return id;
    }


    // Override toString() for a human-friendly representation of the class
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewer='" + reviewer + '\'' +
                ", score=" + score +
                ", confidence=" + confidence +
                ", summary='" + summary + '\'' +
                '}';
    }

    // Override compareTo() for total ordering based on review score
    @Override
    public int compareTo(Review otherReview) {
        return Integer.compare(otherReview.score, this.score); // Descending order based on score
    }

    // Getters for Review attributes
    public int getScore() {
        return score;
    }

    public int getConfidence() {
        return confidence;
    }


}
