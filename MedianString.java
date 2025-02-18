import java.util.*;

public class MedianString {

    public static String medianString(List<String> dna, int k) {
        int minDistance = Integer.MAX_VALUE; // pseudocode - distance ← ∞  
        String median = "";  
        char[] bases = {'A', 'C', 'G', 'T'}; // possible nucleotides  
        List<String> kmers = new ArrayList<>();  

        generateKmers("", k, bases, kmers); // pseudocode - generate all k-mers from aa...aa to tt...tt  
        for (int i = 0; i < kmers.size(); i++) { // pseudocode - for each k-mer pattern from aa…aa to tt…tt  
            String kmer = kmers.get(i);  
            int totalDist = 0; // pseudocode - d(pattern, dna) ← 0  

            for (int j = 0; j < dna.size(); j++) {// loop through each dna sequence  
                String seq = dna.get(j);  
                int minDist = Integer.MAX_VALUE; // pseudocode - d(dnai, pattern) ← ∞  
                // iterate over all k-mers in the current dna sequence  

                for (int l = 0; l <= seq.length() - k; l++) {  
                    int dist = 0;  

                    for (int m = 0; m < k; m++) { // compute hamming distance  
                        if (seq.charAt(l + m) != kmer.charAt(m)) {  
                            dist++; // pseudocode - if hammingdistance(str, pattern) < d(dnai, pattern)  

                        }  
                    }  
                    if (dist < minDist) {  
                        minDist = dist; // pseudocode - d(dnai, pattern) ← hammingdistance(str, pattern)  
                    }  
                }

                totalDist += minDist;  
            }  

              
            if (totalDist < minDistance) { 
                minDistance = totalDist;  
                median = kmer; // pseudocode - median ← pattern  
            }  
        }  

        return median; // pseudocode - return median  
        
    }  

    // generates all possible k-mers recursively  
    public static void generateKmers(String currentKmer, int k, char[] bases, List<String> kmers) {  
        if (k == 0) {  
            kmers.add(currentKmer);  
            return;  
        }  
        for (int i = 0; i < bases.length; i++) {  
            generateKmers(currentKmer + bases[i], k - 1, bases, kmers);  
        }  
    }  

    public static void main(String[] args) {  
        List<String> dna = Arrays.asList("ACGT", "ACGT", "ACGT");
        int k = 3; 
        System.out.println("most likely motif is - " + medianString(dna, k)); 
    }  
}  
