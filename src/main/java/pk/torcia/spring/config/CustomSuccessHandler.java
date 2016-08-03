/**
 * 
 */
package pk.torcia.spring.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author inayat
 *
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		System.out.println("--------->>>>>handle  ");
		String targetUrl = determineTargetUrl(authentication);
		System.out.println("--------->>>>>targeted url  "+targetUrl);
		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/*
	 * This method extracts the roles of currently logged-in user and returns
	 * appropriate URL according to his/her role.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		System.out.println("--------->>>>>determinetarget url 1 ");
		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
			System.out.println("role is  " + roles.toString());
		}
		System.out.println("--------->>>>>determinetarget url 2  ");
		if (isAccountant(roles)) {
			System.out.println("--------->>>>>determinetarget url 3  ");
			url = "/searchStudentDetail";
		} else if (isAdmin(roles)) {
			System.out.println("--------->>>>>determinetarget url 4  ");
			url = "/stHome";
		} else if (isInfoOfficer(roles)) {
			System.out.println("--------->>>>>determinetarget url 5  ");
			url = "/infoStudent";
		} else if (isDEORole(roles)) {
			System.out.println("--------->>>>>determinetarget url 6  ");
			url = "/studentOtherInfo";
		} else {
			System.out.println("--------->>>>>determinetarget url 7  ");
			url = "/accessDenied";
		}

		return url;
	}

	private boolean isInfoOfficer(List<String> roles) {
		if (roles.contains("Information_Role")) {
			System.out.println("--------->>>>> 1 ");
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			System.out.println("--------->>>>> 2 ");
			return true;
		}
		return false;
	}

	private boolean isDEORole(List<String> roles) {
		if (roles.contains("Deo_Role")) {
			System.out.println("--------->>>>> 3 ");
			return true;
		}
		return false;
	}

	private boolean isAccountant(List<String> roles) {
		if (roles.contains("ROLE_AccountantRole")) {
			System.out.println("--------->>>>> 4 ");
			return true;
		}
		return false;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
