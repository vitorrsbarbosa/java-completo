package exercicio02.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private static final SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss" );
	private final List<Comment> comments = new ArrayList<>( );
	private Date moment;
	private String title;
	private String content;
	private Integer likes;

	public Post( ) {
	}

	public Post( Date moment, String title, String content, Integer likes ) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment( ) {
		return moment;
	}

	public void setMoment( Date moment ) {
		this.moment = moment;
	}

	public String getTitle( ) {
		return title;
	}

	public void setTitle( String title ) {
		this.title = title;
	}

	public String getContent( ) {
		return content;
	}

	public void setContent( String content ) {
		this.content = content;
	}

	public Integer getLikes( ) {
		return likes;
	}

	public void setLikes( Integer likes ) {
		this.likes = likes;
	}

	public List<Comment> getComments( ) {
		return comments;
	}

	public void addComment( Comment comment ) {
		comments.add( comment );
	}

	public void removeComment( Comment comment ) {
		comments.remove( comment );
	}

	@Override
	public String toString( ) {
		StringBuilder sb = new StringBuilder( );
		sb.append( getTitle( ) ).append( "\n" )
				.append( getLikes( ) )
				.append( " Likes - " )
				.append( sdf.format( getMoment( ) ) ).append( "\n" )
				.append( getContent( ) ).append( "\n" )
				.append( "Comments:" ).append( "\n" );
		for( Comment comment : comments ) {
			sb.append( comment.getText( ) ).append( "\n" );
		}
		return sb.toString( );
	}
}