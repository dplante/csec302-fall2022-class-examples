FROM python:3.8.5-alpine
COPY . /app
WORKDIR /app
RUN apk add gcc musl-dev python3-dev libffi-dev openssl-dev
RUN python -m pip install --upgrade pip
RUN pip install -r requirements.txt
ENTRYPOINT ["python"]
CMD ["users.py"]
