package wjhk.jupload2.policies;

import java.net.URL;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.milog.mediachoice.MediaChoiceSingletonClient;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.MediaTypes;

import wjhk.jupload2.context.JUploadContext;
import wjhk.jupload2.exception.JUploadException;

public class MediaChoiceUploadPolicy extends DefaultUploadPolicy {

	public MediaChoiceUploadPolicy(JUploadContext juploadContext)
			throws JUploadException {
		super(juploadContext);
		if (getContentId() == null || getContentId().trim() == "") {
			displayErr("ERROR!!!!! no content id!!!");
			throw new JUploadException(
					"No content id was set for this applet, check your parameters");
		}
		this.setMaxChunkSize(50000000);
		this.setMaxFileSize(350000000);
		this.setSendMD5Sum(true);
		this.setNbFilesPerRequest(1);
		this.setRetryNbSecondsBetween(20);
		this.setPostURL("/hd_contents/upload/" + getContentId());
	}
}
