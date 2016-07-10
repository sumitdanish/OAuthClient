// default package
// Generated Jul 10, 2016 7:22:32 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OauthRefreshToken generated by hbm2java
 */
@Entity
@Table(name = "oauth_refresh_token", catalog = "OAuth")
public class OauthRefreshToken implements java.io.Serializable {

	private OauthRefreshTokenId id;

	public OauthRefreshToken() {
	}

	public OauthRefreshToken(OauthRefreshTokenId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "tokenId", column = @Column(name = "token_id", length = 256)),
			@AttributeOverride(name = "token", column = @Column(name = "token")),
			@AttributeOverride(name = "authentication", column = @Column(name = "authentication")) })
	public OauthRefreshTokenId getId() {
		return this.id;
	}

	public void setId(OauthRefreshTokenId id) {
		this.id = id;
	}

}
