package org.visminer.git.remote;

import java.io.IOException;

import org.kohsuke.github.GitHub;
import org.visminer.constants.Services;
/**
 * Provide a connection to a specific remote repository git
 */
public class ConnectionToRepository {

	private String idGit;
	private Services nameRepRemote;
	
	/**
	 * @param ownerRepository :owner's login of a specified repository Git
	 * @param nameRepository :name of this specified repository
	 * @param nameRepRemote : see {@link Services} enum
	 */
	public ConnectionToRepository(String ownerRepository, String nameRepository, Services nameRepRemote){
		
		this.idGit = ownerRepository+ "/"+ nameRepository;
		this.nameRepRemote = nameRepRemote;
		
	}
	
	/**
	 * 
	 * @param login :login of the your Git's remote user
	 * @param password :password of the your Git's remote user
	 * @return a repository's object referent to repository specified in 
	 * third constructor parameter "Services nameRepRemote"
	 */
	public Object getConnection(String login, String password){
		
		if(nameRepRemote == Services.GITHUB){
			
			try {
				GitHub gh = GitHub.connectUsingPassword(login, password);
				return gh.getRepository(idGit);

			} catch (IOException e) {
				System.out.println("Problems in connection:\n" +
						"\n1-probable this repository doesn't exist:" +
						"\n   verify ownerRepository and nameRepository\n"+
						"\n2- probable login or password wrong\n");
			}
		
		}
		return null;
		//TODO make connection to repository BITBUCKET
		
	}


}
