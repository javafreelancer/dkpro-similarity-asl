package de.tudarmstadt.ukp.similarity.dkpro.resource.lexical;

import java.util.Map;

import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceSpecifier;
import org.uimafit.descriptor.ConfigurationParameter;

import de.tudarmstadt.ukp.similarity.algorithms.lexical.ngrams.WordNGramContainmentMeasure;
import de.tudarmstadt.ukp.similarity.dkpro.resource.TextSimilarityResourceBase;


public class WordNGramContainmentResource
	extends TextSimilarityResourceBase
{
	public static final String PARAM_N = "N";
	@ConfigurationParameter(name=PARAM_N, mandatory=true)
	private int n;
	
    @SuppressWarnings("unchecked")
    @Override
    public boolean initialize(ResourceSpecifier aSpecifier, Map aAdditionalParams)
        throws ResourceInitializationException
    {
        if (!super.initialize(aSpecifier, aAdditionalParams)) {
            return false;
        }
        
		measure = new WordNGramContainmentMeasure(n);
        
        return true;
    }
}
