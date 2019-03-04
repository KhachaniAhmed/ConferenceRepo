package org.mql.metier;

import java.util.List;

import org.mql.entities.Article;
import org.mql.entities.View;

public interface IViewMetier {
	List<View> getAll();
	List<View> getViewsAccepted();
	View save(View view);

}
