FROM python:3.8
WORKDIR /app

COPY . .

ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0

RUN chmod +x init_setup.sh
RUN ./init_setup.sh

EXPOSE 8080
# CMD ["flask", "run", "--host", "0.0.0.0", "--port", "8080"]

ENTRYPOINT [ "python3" ]
CMD ["app.py"]