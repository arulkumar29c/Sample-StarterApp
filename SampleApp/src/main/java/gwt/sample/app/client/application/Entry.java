
package gwt.sample.app.client.application;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Entry implements EntryPoint {
	@SuppressWarnings("deprecation")
	@Override
	public void onModuleLoad() {

		// final FormPanel uploadForm=new FormPanel();
		// uploadForm.setAction(GWT.getModuleBaseURL() + "FormUploadFile");
		// uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		// uploadForm.setMethod(FormPanel.METHOD_POST);
		// VerticalPanel panel=new VerticalPanel();
		// uploadForm.setWidget(panel);
		// final TextBox tb=new TextBox();
		// tb.setName("textBoxFormElement");
		// panel.add(tb);
		// FileUpload upload=new FileUpload();
		// upload.setName("uploadFormElement");
		// panel.add(upload);
		// Button uploadSubmitButton=new Button("Upload");
		// panel.add(uploadSubmitButton);
		// uploadSubmitButton.addClickListener(new ClickListener(){
		// public void onClick( Widget sender){
		// uploadForm.submit();
		// }
		// }
		// );
		// uploadForm.addFormHandler(new FormHandler(){
		// public void onSubmit( FormSubmitEvent event){
		// }
		// public void onSubmitComplete( FormSubmitCompleteEvent event){
		// Window.alert(event.getResults());
		// }
		// }
		// );
		// RootPanel.get().add(uploadForm);
		RootPanel.get().add(HomeScreen.getHomescreen());
	}
}
