package org.mql.metier;

import java.util.List;

import org.mql.entities.Reviewer;
import org.mql.entities.View;

public interface IReviewerMetier {
	
	Reviewer findByUsername(String username);
}
