package com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.domain;

import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.AlipayObject;
import com.enation.app.shop.component.payment.plugin.alipay.sdk34.api.internal.mapping.ApiField;

/**
 * 车险图像定损请求中的图像信息
 *
 * @author auto create
 * @since 1.0, 2017-03-16 09:53:40
 */
public class AlipayInsDataAutodamageRequestImageInfo extends AlipayObject {

	private static final long serialVersionUID = 8754719139866662463L;

	/**
	 * 图像文件名称
	 */
	@ApiField("image_name")
	private String imageName;

	/**
	 * 图像文件在存储上的路径
	 */
	@ApiField("image_path")
	private String imagePath;

	public String getImageName() {
		return this.imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return this.imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
