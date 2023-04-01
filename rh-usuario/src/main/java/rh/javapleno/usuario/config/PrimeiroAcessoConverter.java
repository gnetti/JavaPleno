package rh.javapleno.usuario.config;

import javax.persistence.AttributeConverter;

public class PrimeiroAcessoConverter implements AttributeConverter<Boolean, Boolean> {
    @Override
    public Boolean convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null)
            return Boolean.FALSE;
         else
            return attribute;

    }

    @Override
    public Boolean convertToEntityAttribute(Boolean dbData) {
        if(dbData == null)
            return Boolean.FALSE;
         else
            return dbData;

    }
}
