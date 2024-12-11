package Practical_12;

import java.util.List;

// Class representing the publication system
class PublicationSystem {

    public static void main(String[] args) {
        // Create three papers
        Paper paper1 = new Paper(1, "Paper 1", List.of("Author 1", "Author 2"));
        Paper paper2 = new Paper(2, "Paper 2", List.of("Author 3", "Author 4"));
        Paper paper3 = new Paper(3, "Paper 3", List.of("Author 5", "Author 6"));

        // Submit, update, and retract reviews for each paper
        submitUpdateRetractReviews(paper1);
        submitUpdateRetractReviews(paper2);
        submitUpdateRetractReviews(paper3);

        // Assign 'Best Paper Award' by calculating the weighted average score for each paper
        assignBestPaperAward(paper1);
        assignBestPaperAward(paper2);
        assignBestPaperAward(paper3);
    }

    // Method to submit, update, and retract reviews for a paper
    private static void submitUpdateRetractReviews(Paper paper) {
        // Submit reviews
        Review review1 = new Review(1, "Reviewer 1", 8, 4, "Good paper");
        Review review2 = new Review(2, "Reviewer 2", 7, 3, "Interesting work");
        paper.submitReview(review1);
        paper.submitReview(review2);

        // Update reviews
        Review updatedReview1 = new Review(1, "Reviewer 1", 9, 5, "Excellent paper");
        paper.updateReview(updatedReview1);

        // Retract reviews
        paper.retractReview(2);
    }

    // Method to assign the 'Best Paper Award' by calculating the weighted average score
    private static void assignBestPaperAward(Paper paper) {
        double totalWeightedScore = 0;
        int totalWeight = 0;

        for (Review review : paper.getReviewList()) {
            totalWeightedScore += review.getScore() * review.getConfidence();
            totalWeight += review.getConfidence();
        }

        if (totalWeight > 0) {
            double weightedAverageScore = totalWeightedScore / totalWeight;
            System.out.println("Best Paper Award for '" + paper.getTitle() + "': " + weightedAverageScore);
        } else {
            System.out.println("No reviews available for '" + paper.getTitle() + "'.");
        }
    }
}