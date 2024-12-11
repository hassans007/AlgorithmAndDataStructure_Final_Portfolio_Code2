# Alogrithm and Data Structure Practical 12: Publication System

## Overview

The **Publication System** is an application designed to simulate the management of paper reviews in a publication process. This system allows for the submission, updating, and retraction of reviews for papers, and it also calculates the weighted average score of reviews to assign a "Best Paper Award" to the most highly rated paper.

## Components

### Classes and Functionality:

1. **Review**:
   - This class represents a review submitted by a reviewer for a specific paper.
   - It includes attributes like:
     - `id`: Unique identifier for the review.
     - `reviewer`: Name of the reviewer.
     - `score`: The score given by the reviewer (on a scale from 1 to 10).
     - `confidence`: The reviewer's confidence in their assessment (on a scale from 1 to 5).
     - `summary`: A brief text summarizing the reviewer's thoughts on the paper.
   - Implements the `Comparable<Review>` interface to allow sorting of reviews by score in descending order.

2. **Paper**:
   - Represents a paper to which reviews are submitted.
   - Attributes:
     - `id`: Unique identifier for the paper.
     - `title`: Title of the paper.
     - `authors`: A list of authors for the paper.
     - `reviewList`: A list of reviews associated with the paper.
   - Methods:
     - `submitReview(Review review)`: Allows submitting a review for a paper. Reviews are automatically sorted in descending order of score.
     - `updateReview(Review updatedReview)`: Allows updating an existing review by replacing it with a new one.
     - `retractReview(int reviewId)`: Allows retracting (removing) a review based on its ID.
     - Helper method `printReviewList()`: Prints the list of reviews for the paper to the console.

3. **PublicationSystem**:
   - The main class that simulates the publication system.
   - It includes methods for:
     - **Submitting, updating, and retracting reviews** for papers using the method `submitUpdateRetractReviews()`.
     - **Assigning the Best Paper Award** based on the weighted average score of reviews using the method `assignBestPaperAward()`.
   - It creates sample papers and performs various operations to demonstrate how reviews are handled and how the award is calculated.

## Key Features

- **Review Management**: Allows adding, updating, and removing reviews for papers. Reviews are automatically sorted based on the score, with higher scores appearing first.
- **Best Paper Award Calculation**: Calculates the weighted average score for each paper based on its reviews' scores and confidence levels. The weighted average helps in determining which paper should receive the Best Paper Award.
- **Dynamic Updates**: The review list is updated dynamically when new reviews are submitted, existing reviews are updated, or reviews are retracted.

## Example Workflow

1. **Paper Creation**:
   - Three example papers are created, each with a unique title and set of authors.

2. **Review Submission**:
   - Reviews are submitted for each paper with a score and confidence level. Reviews are automatically sorted by score, with the highest score at the top.

3. **Review Update**:
   - Reviews can be updated if the reviewer changes their opinion. The review list is resorted automatically after each update.

4. **Review Retraction**:
   - A review can be retracted, removing it from the review list.

5. **Best Paper Award Calculation**:
   - The system calculates the weighted average score for each paper based on its reviews. The paper with the highest weighted score receives the Best Paper Award.

## Code Example

```java
// Creating a paper and submitting reviews
Paper paper1 = new Paper(1, "Paper 1", List.of("Author 1", "Author 2"));
Review review1 = new Review(1, "Reviewer 1", 8, 4, "Good paper");
paper1.submitReview(review1);

// Updating a review
Review updatedReview1 = new Review(1, "Reviewer 1", 9, 5, "Excellent paper");
paper1.updateReview(updatedReview1);

// Retracting a review
paper1.retractReview(1);

// Calculating Best Paper Award
assignBestPaperAward(paper1);

# Paper Review System

## Example Output

### After submitting a review:

```bash
Review List for Paper 'Paper 1':
Review{id=1, reviewer='Reviewer 1', score=9, confidence=5, summary='Excellent paper'}

Best Paper Award for 'Paper 1': 9.0
```
### Conclusion
This system is a simplified model for handling paper reviews and assigning awards in an academic publishing context. It demonstrates core concepts such as sorting, updating data, and calculating weighted averages, making it a useful exercise for understanding object-oriented programming in Java.
