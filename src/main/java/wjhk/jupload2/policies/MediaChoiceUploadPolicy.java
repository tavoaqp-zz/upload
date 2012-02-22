package wjhk.jupload2.policies;

import wjhk.jupload2.context.JUploadContext;
import wjhk.jupload2.exception.JUploadException;

public class MediaChoiceUploadPolicy extends DefaultUploadPolicy{

	public MediaChoiceUploadPolicy(JUploadContext juploadContext)
			throws JUploadException {
		super(juploadContext);
		if (getContentId()==null || getContentId().trim()=="")
		{
			displayErr("ERROR!!!!! no content id!!!");
			throw new JUploadException("No content id was set for this applet, check your parameters");
		}
		this.setPostURL("/hd_contents/upload/"+getContentId());
	}

}
