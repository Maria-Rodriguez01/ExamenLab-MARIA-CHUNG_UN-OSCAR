package examenlab.maria.chung_un.oscar;

import java.util.ArrayList;

public class Facebook extends SocialClass implements Comentable {

    ArrayList<Comment> comments;

    public Facebook(String username) {
        super(username);
        this.comments = new ArrayList<>();

    }

    @Override
    public void timeline() {
        StringBuilder timeline = new StringBuilder();
        if (posts.isEmpty()) {
            timeline.append("No hay ningun post");
            timeline.toString();
        }
        for (int i = 0; i < posts.size(); i++) {
            timeline.append("POST ").append(i).append(": ").append(posts.get(i)).append("\n");
        int commentCount = 0;
        for (Comment comment : comments) {
            if (comment.postId == i) {
                timeline.append((commentCount + 1)).append(". ").append(comment.print()).append("\n");
                commentCount++;
            }
            
        }
        if (commentCount == 0) {
                timeline.append("   (Sin comentarios)\n");
            }
            timeline.append("\n");
        }
        timeline.toString();
        
        
            }

    @Override
    public boolean addComment(Comment comment) {
        int postId = comment.postId;
        if (postId < 0 || postId >= posts.size()) {
            return false;
        }
        comments.add(comment);
        return true;

    }

}
