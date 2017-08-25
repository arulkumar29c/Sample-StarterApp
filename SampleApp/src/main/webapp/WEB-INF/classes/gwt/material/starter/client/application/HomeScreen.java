/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package gwt.material.starter.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.starter.client.autoComplete.AutoCompleteView;

public class HomeScreen extends Composite {

	private static HomeScreen homescreen = null;
	private static HomeViewUiBinder uiBinder = GWT.create(HomeViewUiBinder.class);

	@UiTemplate("HomePage.ui.xml")
	interface HomeViewUiBinder extends UiBinder<Widget, HomeScreen> {
	}

	@UiField
	MaterialContainer m_container;
	@UiField
	MaterialSideNav m_sideNav;
	@UiField
	MaterialNavBar m_navBar;
	@UiField
	MaterialLabel m_label_home;
	@UiField
	MaterialLink m_link_allocation, m_link_function, m_link_email_template, m_link_export, m_link_deputy;
	@UiField
	MaterialRow screenHeading,info_row;
	@UiField
	MaterialImage m_image;
	@UiField
	MaterialIcon headingIcon;

	private HomeScreen() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@Override
	protected void onLoad() {
		super.onLoad();
		m_navBar.getElement().setId("nav-header");
		info_row.getElement().setId("nav-header");
		setAppLog();
		landingPage();
		initMaterialLinkEvent();

	}

	private void landingPage() {
		addWidget(new AutoCompleteView(), "Manage E-Mail Templates",IconType.DRAFTS);
		rowPaddingTop2(); 

	}

	private void initMaterialLinkEvent() {
		m_link_allocation.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				addWidget(new AllocationView(), "Allocation",IconType.INPUT);
				sideNavClose();
			}
		});
		m_link_function.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				addWidget(new FunctionView(), "Manage Functions",IconType.COLLECTIONS_BOOKMARK);
				sideNavClose();
			}
		});
		m_link_email_template.setIconColor(Color.LIGHT_GREEN_DARKEN_2);
		m_link_email_template.setFontWeight(FontWeight.BOLD);
		m_link_email_template.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//			addWidget(new ManageEMailView(), "Manage E-Mail Templates",IconType.DRAFTS);
				addWidget(new AutoCompleteView(), "Manage E-Mail Templates",IconType.DRAFTS);
				sideNavClose();
			}
		});
		m_link_export.setIconColor(Color.RED_DARKEN_2);
		m_link_export.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				addWidget(new ExportReportView(), "Export Report",IconType.FILTER_1);
				sideNavClose();
			}
		});
		m_link_deputy.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				addWidget(new ManageDeputyView(), "Manage Deputy",IconType.SUPERVISOR_ACCOUNT);
				sideNavClose();
			}
		});

	}

	private void clear() {

		if (m_container != null && m_container.getWidgetCount() > 1) {
			m_container.getWidget(1).removeFromParent();
		}

	}

	public void addWidget(Widget widget, String title,IconType type) {
		clear();
		m_label_home.setText(title);
		headingIcon.setIconType(type);
		SimplePanel appWidget = new SimplePanel();
		appWidget.add(widget);
		m_container.add(appWidget);
	}

	public static HomeScreen getHomescreen() {
		if (homescreen == null) {
			homescreen = new HomeScreen();
		}
		return homescreen;
	}

	private void setAppLog() {
//		m_image.setResource(BundleResource.INSTANCE.swissreLogo());
		m_image.setMarginTop(10);
		m_image.setMarginLeft(30);
	}

	public void pageUnderDev(MaterialImage m_image) {

//		m_image.setResource(BundleResource.INSTANCE.pageDevlopment());
		m_image.setDisplay(Display.BLOCK);
	}

	public void rowPaddingTop(MaterialRow m_row) {
		m_row.setPaddingTop(0);

	}
	public void rowPaddingTop2() {
		screenHeading.setPaddingTop(15);

	}

	private void sideNavClose() {
		m_sideNav.hide();
	}

}
