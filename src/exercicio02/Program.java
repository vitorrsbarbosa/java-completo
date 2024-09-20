package exercicio02;

import exercicio02.entities.Comment;
import exercicio02.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Program {
	public static void main( String[] args ) throws ParseException {
		Locale.setDefault( Locale.US );
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy HH:mm:ss", Locale.US );
		Post post1 = new Post(
				sdf.parse( "21/06/2018 13:05:44" ),
				"Traveling to New Zealand",
				"I'm going to visit this wonderful country!",
				12 );
		Post post2 = new Post(
				sdf.parse( "28/07/2018 23:14:19" ),
				"Good night guys",
				"See you tomorrow",
				5 );
		Comment c11 = new Comment( "Have a nice trip!" );
		Comment c12 = new Comment( "Wow That's awesome!" );
		Comment c21 = new Comment( "Good night" );
		Comment c22 = new Comment( "May the Force be with you" );
		post1.addComment( c11 );
		post1.addComment( c12 );
		post2.addComment( c21 );
		post2.addComment( c22 );
		System.out.println( post1 );
		System.out.println( post2 );
	}
}
