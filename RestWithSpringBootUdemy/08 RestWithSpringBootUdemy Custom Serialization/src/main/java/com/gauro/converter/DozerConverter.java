package com.gauro.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chandra
 */
public class DozerConverter {
    private static Mapper mapper= DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject(O origin, Class<D>  destination){
        return mapper.map(origin,destination);
    }
    public static <O,D> List<D> parseListObjects(List<O> origin, Class<D> destination){
       // List<D> destinationObjects=new ArrayList<>();
      //  origin.forEach(o-> destinationObjects.add(mapper.map(o,destination)));
      //  return destinationObjects;

       return origin.stream().map(o->mapper.map(o, destination)).collect(Collectors.toList());


    }
}