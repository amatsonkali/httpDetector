package mx.itesm.httpddosdetector.classifier.randomtree.codec;

import mx.itesm.httpddosdetector.classifier.randomforest.RandomForestBinClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weka.classifiers.trees.RandomTree;

/**
 * Codec to load a Weka serialized model into a random forest classifier
 */
public class RandomTreeCodec {
    private static Logger log = LoggerFactory.getLogger(RandomTreeCodec.class);

    public RandomTree decode(String modelPath) {
        log.debug("Constructing RandomTree...");
        RandomTree randomTree = new RandomTree();
        try {
            randomTree = (RandomTree)
                   weka.core.SerializationHelper.read(modelPath);
            log.info("Random tree classifier loaded");
        } catch (Exception e) {
            log.error("Error while loading random forest classifier");
            log.error(e.getMessage());
        }
        return randomTree;
    }
}