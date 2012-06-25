/*******************************************************************************
 * Copyright 2011, 2012
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.similarity.dkpro.resource;

import org.uimafit.descriptor.ConfigurationParameter;

import de.tudarmstadt.ukp.similarity.algorithms.api.TextSimilarityMeasure;


public class TextSimilarityDefaultResource
    extends TextSimilarityResourceBase
{
	public static final String MSG_CANNOT_INITIALIZE = "Cannot initialize text similarity resource. Base measure not found.";
		
	public static final String PARAM_TEXT_SIMILARITY_MEASURE = "TextSimilarityMeasure";
	@ConfigurationParameter(name=PARAM_TEXT_SIMILARITY_MEASURE, mandatory=true)
	private String textSimilarityMeasureName;
	
	@Override
    public void afterResourcesInitialized()
    {
    	super.afterResourcesInitialized();
    	
        try {
			measure = (TextSimilarityMeasure) Class.forName(textSimilarityMeasureName).newInstance();
		}
		catch (InstantiationException e) {
			getLogger().error(MSG_CANNOT_INITIALIZE);
		}
		catch (IllegalAccessException e) {
			getLogger().error(MSG_CANNOT_INITIALIZE);
		}
		catch (ClassNotFoundException e) {
			getLogger().error(MSG_CANNOT_INITIALIZE);
		}
    }
}