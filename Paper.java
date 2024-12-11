package Practical_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class representing a paper with reviews
class Paper {

    private int id;
    private String title;
    private List<String> authors;
    private List<Review> reviewList;

    // Constructor for Paper
    public Paper(int id, String title, List<String> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.reviewList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    // Submits a review for a paper
    public void submitReview(Review review) {
        if (!reviewList.contains(review)) {
            reviewList.add(review);
            Collections.sort(reviewList); // Maintain descending order based on review score
            printReviewList();
        }
    }

    // Updates an existing review for a paper
    public void updateReview(Review updatedReview) {
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getId() == updatedReview.getId()) {
                reviewList.set(i, updatedReview);
                Collections.sort(reviewList); // Reflect changes in the ordering based on review score
                printReviewList();
                return;
            }
        }
    }

    // Retracts an existing review for a paper
    public void retractReview(int reviewId) {
        reviewList.removeIf(review -> review.getId() == reviewId);
        printReviewList();
    }

    // Helper method to print the review list for the paper
    private void printReviewList() {
        System.out.println("Review List for Paper '" + title + "':");
        for (Review review : reviewList) {
            System.out.println(review);
        }
        System.out.println();
    }
}
