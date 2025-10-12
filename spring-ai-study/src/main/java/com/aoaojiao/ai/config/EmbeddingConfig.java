package com.aoaojiao.ai.config;

import com.knuddels.jtokkit.api.EncodingType;
import org.springframework.ai.embedding.BatchingStrategy;
import org.springframework.ai.embedding.TokenCountBatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DD
 */
@Configuration
public class EmbeddingConfig {

    @Bean
    public BatchingStrategy customTokenCountBatchingStrategy() {
        return new TokenCountBatchingStrategy(
                EncodingType.CL100K_BASE,  // Specify the encoding type
                7000,                      // Set the maximum input token count
                0.1                        // Set the reserve percentage
        );
    }

//    @Bean
//    public VectorStore vectorStore(JdbcTemplate jdbcTemplate,
//                                         EmbeddingModel embeddingModel) {
//        return PgVectorStore.builder(jdbcTemplate, embeddingModel)
//                .dimensions(1536)                    // Optional: defaults to model dimensions or 1536
//                .distanceType(COSINE_DISTANCE)       // Optional: defaults to COSINE_DISTANCE
//                .indexType(HNSW)                     // Optional: defaults to HNSW
//                .initializeSchema(true)              // Optional: defaults to false
//                .schemaName("public")                // Optional: defaults to "public"
//                .vectorTableName("vector_store")     // Optional: defaults to "vector_store"
//                .maxDocumentBatchSize(10000)         // Optional: defaults to 10000
//                .build();
//    }
}
