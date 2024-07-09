public class ClassificationService {
    Classification findClassificationByName(String classificationName){
        return Classification.valueOf(classificationName.toUpperCase());
    }
}
